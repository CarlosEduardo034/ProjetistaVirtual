package com.fotovoltaico.backend.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fotovoltaico.backend.model.Inversor;
import com.fotovoltaico.backend.model.Modulo;
import com.fotovoltaico.backend.model.Projeto;

public class ExcelService {

    private Cell getOrCreateCell(Sheet sheet, int rowIndex, int colIndex) {
        Row row = sheet.getRow(rowIndex);
        if (row == null) row = sheet.createRow(rowIndex);

        Cell cell = row.getCell(colIndex);
        if (cell == null) cell = row.createCell(colIndex);

        return cell;
    }

    public void preencherFormulario(String caminhoArquivo, Projeto projeto) {
        try {
            FileInputStream fis = new FileInputStream(caminhoArquivo);
            Workbook workbook = new XSSFWorkbook(fis);

            Sheet aba = workbook.getSheetAt(1);
            if (projeto.getModulos() != null && !projeto.getModulos().isEmpty()) {
                Modulo m = projeto.getModulos().get(0);
                
                getOrCreateCell(aba, 6, 3).setCellValue(projeto.getModulos().get(0).getPotencia());
                getOrCreateCell(aba, 6, 7).setCellValue(projeto.getModulos().get(0).getQuantidade());
                getOrCreateCell(aba, 6, 15).setCellValue(projeto.getModulos().get(0).getArea());
                getOrCreateCell(aba, 6, 19).setCellValue(projeto.getModulos().get(0).getFabricante());
                getOrCreateCell(aba, 6, 26).setCellValue(projeto.getModulos().get(0).getModelo());
            }
            if (projeto.getInversores() != null && !projeto.getInversores().isEmpty()) {
                Inversor i = projeto.getInversores().get(0);

                getOrCreateCell(aba, 21, 3).setCellValue(projeto.getInversores().get(0).getFabricante());
                getOrCreateCell(aba, 21, 7).setCellValue(projeto.getInversores().get(0).getModelo());
                getOrCreateCell(aba, 21, 11).setCellValue(projeto.getInversores().get(0).getPotenciaNominal());
                getOrCreateCell(aba, 21, 15).setCellValue(projeto.getInversores().get(0).getTensaoOperacao());
                getOrCreateCell(aba, 21, 19).setCellValue(projeto.getInversores().get(0).getCorrenteNominal());
                getOrCreateCell(aba, 21, 22).setCellValue(projeto.getInversores().get(0).getFatorPotencia());
                getOrCreateCell(aba, 21, 25).setCellValue(projeto.getInversores().get(0).getRendimento());
                getOrCreateCell(aba, 21, 28).setCellValue(projeto.getInversores().get(0).getDht());
            }
            FileOutputStream fos = new FileOutputStream(caminhoArquivo);
            workbook.write(fos);

            fos.close();
            workbook.close();
            fis.close();
            
            System.out.println("Excel preenchido com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}