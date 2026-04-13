package com.fotovoltaico.backend.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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

            getOrCreateCell(aba, 6, 3).setCellValue(projeto.getModulo().getPotencia());
            getOrCreateCell(aba, 6, 7).setCellValue(projeto.getModulo().getQuantidade());
            getOrCreateCell(aba, 6, 15).setCellValue(projeto.getModulo().getArea());
            getOrCreateCell(aba, 6, 19).setCellValue(projeto.getModulo().getFabricante());
            getOrCreateCell(aba, 6, 26).setCellValue(projeto.getModulo().getModelo());

            getOrCreateCell(aba, 21, 3).setCellValue(projeto.getInversor().getFabricante());
            getOrCreateCell(aba, 21, 7).setCellValue(projeto.getInversor().getModelo());
            getOrCreateCell(aba, 21, 11).setCellValue(projeto.getInversor().getPotenciaNominal());
            getOrCreateCell(aba, 21, 15).setCellValue(projeto.getInversor().getTensaoOperacao());
            getOrCreateCell(aba, 21, 19).setCellValue(projeto.getInversor().getCorrenteNominal());
            getOrCreateCell(aba, 21, 22).setCellValue(projeto.getInversor().getFatorPotencia());
            getOrCreateCell(aba, 21, 25).setCellValue(projeto.getInversor().getRendimento());
            getOrCreateCell(aba, 21, 28).setCellValue(projeto.getInversor().getDht());
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