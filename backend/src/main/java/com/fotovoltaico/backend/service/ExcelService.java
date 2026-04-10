package com.fotovoltaico.backend.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fotovoltaico.backend.model.Projeto;

public class ExcelService {

    public void preencherFormulario(String caminhoArquivo, Projeto projeto) {

        try {
            FileInputStream fis = new FileInputStream(caminhoArquivo);
            Workbook workbook = new XSSFWorkbook(fis);

            Sheet aba = workbook.getSheetAt(1);

            aba.getRow(6).getCell(3).setCellValue(projeto.getModulo().getPotencia());
            aba.getRow(6).getCell(7).setCellValue(projeto.getModulo().getQuantidade());
            aba.getRow(6).getCell(15).setCellValue(projeto.getModulo().getArea());
            aba.getRow(6).getCell(19).setCellValue(projeto.getModulo().getFabricante());
            aba.getRow(6).getCell(26).setCellValue(projeto.getModulo().getModelo());
            
            aba.getRow(21).getCell(3).setCellValue(projeto.getInversor().getFabricante());
            aba.getRow(21).getCell(7).setCellValue(projeto.getInversor().getModelo());
            aba.getRow(21).getCell(11).setCellValue(projeto.getInversor().getPotenciaNominal());
            aba.getRow(21).getCell(15).setCellValue(projeto.getInversor().getTensaoOperacao());
            aba.getRow(21).getCell(19).setCellValue(projeto.getInversor().getCorrenteNominal());
            aba.getRow(21).getCell(22).setCellValue(projeto.getInversor().getFatorPotencia());
            aba.getRow(21).getCell(25).setCellValue(projeto.getInversor().getRendimento());
            aba.getRow(21).getCell(28).setCellValue(projeto.getInversor().getDht());

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