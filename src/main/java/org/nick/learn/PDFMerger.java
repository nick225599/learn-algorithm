package org.nick.learn;




import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfReader;

import java.io.FileOutputStream;
import java.io.IOException;

public class PDFMerger {
    public static String path = "C:\\tmp\\";

    public static void main(String[] args) {
        // 要合并的4个PDF文件路径
        String[] pdfFiles = {
                "平安银行个人账户交易明细 JYLS250801099191-1.pdf",
                "平安银行个人账户交易明细 JYLS250801099191-2.pdf",
                "平安银行个人账户交易明细 JYLS250801099191-3.pdf",
                "平安银行个人账户交易明细 JYLS250801099191-4.pdf",
        };

        // 合并后的PDF文件路径
        String outputFile = "平安银行个人账户交易明细 JYLS250801099191-from1to4.pdf";

        try {
            // 执行合并操作
            mergePDFs(pdfFiles, outputFile);
            System.out.println("PDF文件合并成功！输出文件: " + outputFile);
        } catch (DocumentException | IOException e) {
            System.err.println("合并PDF时发生错误: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 将多个PDF文件合并为一个
     * @param pdfFiles 要合并的PDF文件路径数组
     * @param outputFile 合并后的输出文件路径
     * @throws DocumentException 文档处理异常
     * @throws IOException IO异常
     */
    public static void mergePDFs(String[] pdfFiles, String outputFile)
            throws DocumentException, IOException {

        // 创建一个新的文档
        Document document = new Document();

        // 创建PdfCopy对象，用于将多个PDF内容复制到新文档
        PdfCopy copy = new PdfCopy(document, new FileOutputStream(path + outputFile));

        // 打开文档
        document.open();

        // 循环处理每个PDF文件
        for (String pdfFile : pdfFiles) {
            // 读取PDF文件
            PdfReader reader = new PdfReader(path + pdfFile);

            // 获取PDF文件的页数
            int numberOfPages = reader.getNumberOfPages();

            // 将每一页添加到新文档中
            for (int i = 1; i <= numberOfPages; i++) {
                copy.addPage(copy.getImportedPage(reader, i));
            }

            // 释放资源
            reader.close();
        }

        // 关闭文档
        document.close();
    }
}
