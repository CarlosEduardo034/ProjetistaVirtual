package com.fotovoltaico.backend.service;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;

public class PdfService {

    public void exportarAbasParaPdf(String caminhoExcel, String pastaDestino) {

        ActiveXComponent excel = new ActiveXComponent("Excel.Application");

        try {
            excel.setProperty("Visible", false);

            Dispatch workbooks = excel.getProperty("Workbooks").toDispatch();
            Dispatch workbook = Dispatch.call(workbooks, "Open", caminhoExcel).toDispatch();

            Dispatch sheets = Dispatch.get(workbook, "Worksheets").toDispatch();

            // =========================
            // ABA 01 (índice 2)
            // =========================
            exportarAba(sheets, 2, pastaDestino + "/Dados dos equipamentos.pdf");

            // =========================
            // ABA 02 (índice 3)
            // =========================
            exportarAba(sheets, 3, pastaDestino + "/Formulario de solicitacao de orcamento.pdf");

            // =========================
            // ABA 03 (índice 4)
            // =========================
            exportarAba(sheets, 4, pastaDestino + "/Lista de Rateio.pdf");

            Dispatch.call(workbook, "Close", false);

            System.out.println("PDFs separados gerados com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            excel.invoke("Quit");
        }
    }

    private void exportarAba(Dispatch sheets, int index, String caminhoPdf) {
        Dispatch aba = Dispatch.call(sheets, "Item", index).toDispatch();

        // Ativa a aba
        Dispatch.call(aba, "Activate");

        // =========================
        // CONFIGURAÇÃO DE IMPRESSÃO
        // =========================
        Dispatch pageSetup = Dispatch.get(aba, "PageSetup").toDispatch();

        // Força caber em 1 página (largura e altura)
        Dispatch.put(pageSetup, "Zoom", false);
        Dispatch.put(pageSetup, "FitToPagesWide", 1);
        Dispatch.put(pageSetup, "FitToPagesTall", 1);

        // Exporta
        Dispatch.call(aba, "ExportAsFixedFormat", 0, caminhoPdf);
    }
}
