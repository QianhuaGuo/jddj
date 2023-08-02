package org.example;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.MemberValuePair;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {
    /**
     * com.github.houbb.javaparser.learn.chap1
     */
    private static final String FILE_PATH = "D:\\workspace\\java\\pem\\src\\main\\java\\com\\baozun\\pem\\model\\entity\\RebuildLinkTask.java";

    private static List<String> fileList = new ArrayList<>();

    public static void traverseFolder(File folder) throws FileNotFoundException {
        if (folder.isDirectory()) { // 如果当前文件是文件夹
            System.out.println("当前文件夹: " + folder.getAbsolutePath()); // 输出文件夹路径
            if(folder.getAbsolutePath().contains(".idea") ||
                    folder.getAbsolutePath().contains(".git") ||
                    folder.getAbsolutePath().contains(".gradle")){
                return;
            }
            File[] files = folder.listFiles(); // 获取文件夹下的所有文件和子文件夹
            if (files != null) { // 判断文件夹是否为空
                for (File file : files) { // 遍历文件夹下的所有文件和子文件夹
                    traverseFolder(file); // 递归遍历子文件夹
                }
            }
        } else { // 如果当前文件不是文件夹
            System.out.println("当前文件: " + folder.getAbsolutePath()); // 输出文件路径
            fileList.add(folder.getAbsolutePath());
        }
    }

    public static void main(String[] args) throws Exception {

        //String folderPath = "D:\\workspace\\java\\pem\\src\\main\\java\\com\\baozun\\pem\\model\\entity\\"; // 指定要遍历的文件夹路径
        String folderPath = "D:\\projectall\\report-service";
        File folder = new File(folderPath); // 将路径转换为File对象
        traverseFolder(folder); // 调用递归遍历方法

        List<DataDictionaryItem> items = new ArrayList<>();
        for (String s : fileList) {
            if(!s.endsWith("java")){
                continue;
            }
            CompilationUnit cu = null;
            try {
                cu = StaticJavaParser.parse(new FileInputStream(s));
            } catch (Exception e) {
                continue;
            }
            List<Node> childNodes = cu.getChildNodes();
            List<Node> declarationList = childNodes.stream().filter(x -> x.getClass().equals(ClassOrInterfaceDeclaration.class)).collect(Collectors.toList());
            for (Node node : declarationList) {
                boolean flag = true;
                NodeList<AnnotationExpr> annotations = ((ClassOrInterfaceDeclaration) node).getAnnotations();

                List<Node> field = node.getChildNodes().stream().filter(x -> x.getClass().equals(FieldDeclaration.class)).collect(Collectors.toList());
                for (Node item : field) {
                    DataDictionaryItem dictionaryItem = new DataDictionaryItem();
                    if (flag) {
                        try {
                            List<AnnotationExpr> document = annotations.stream().filter(x -> x.getName().toString().equals("Document")).collect(Collectors.toList());
                            if (CollectionUtils.isEmpty(document)) {
                                continue;
                            }
                            Node node1 = document.get(0).getChildNodes().get(1);
                            String s1 = node1.toString();
                            if ("true".equals(s1)) {
                                dictionaryItem.setCollectionName(((MemberValuePair) annotations.get(1).getChildNodes().get(1)).getValue().toString());
                            } else {
                                dictionaryItem.setCollectionName(s1.replace("\"", ""));
                            }

                        } catch (Exception e) {
                            continue;
                        }
                    }
                    dictionaryItem.setFieldName(((FieldDeclaration) item).getVariables().get(0).toString());
                    flag = false;
                    dictionaryItem.setFieldType(((FieldDeclaration) item).getVariables().get(0).getType().toString());
//                    System.out.print(((FieldDeclaration) item).getVariables().get(0) + "           ");
//                    System.out.print(((FieldDeclaration) item).getVariables().get(0).getType() + "           ");
                    if (item.getComment().isPresent()) {
//                        System.out.println(item.getComment().get().getContent().replace("\r\n", "").replace("*", "").replace(" ", ""));
                        dictionaryItem.setComment(item.getComment().get().getContent().replace("\r\n", "").replace("*", "").replace(" ", ""));
                    } else {
                        //   System.out.println();
                    }
                    items.add(dictionaryItem);
                }
            }

        }
        EasyExcel.write("test1.xlsx", DataDictionaryItem.class)
                .sheet("模板")
                .doWrite(items);

//        CompilationUnit cu = StaticJavaParser.parse(new FileInputStream(FILE_PATH));
//        List<Node> childNodes = cu.getChildNodes();
//        List<Node> declarationList = childNodes.stream().filter(x -> x.getClass().equals(ClassOrInterfaceDeclaration.class)).collect(Collectors.toList());
//        for (Node node : declarationList) {
//            NodeList<AnnotationExpr> annotations = ((ClassOrInterfaceDeclaration) node).getAnnotations();
//
//            List<Node> field = node.getChildNodes().stream().filter(x -> x.getClass().equals(FieldDeclaration.class)).collect(Collectors.toList());
//            for (Node item : field) {
//                System.out.print(((FieldDeclaration) item).getVariables().get(0) + "           ");
//                System.out.print(((FieldDeclaration) item).getVariables().get(0).getType() + "           ");
//                if (item.getComment().isPresent()) {
//                    System.out.println(item.getComment().get().getContent().replace("\r\n", "").replace("*", "").replace(" ", ""));
//                } else {
//                    System.out.println();
//                }
//            }
//        }

        //com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
        //getChildNodes
        //FieldDeclaration


        //List<Comment> comments = cu.getComments();

        // System.out.println(comments);


        //System.out.println(cu.getAllContainedComments());
//        VoidVisitor<?> methodNameVisitor = new MethodNamePrinter();
//        methodNameVisitor.visit(cu, null);
//
//        List<String> methodNames = new ArrayList<>();
//        VoidVisitor<List<String>> methodNameCollector = new MethodNameCollector();
//        methodNameCollector.visit(cu, methodNames);
//        methodNames.forEach(n -> System.out.println("Method Name Collected: " + n));
    }

    @Data
    public static class DataDictionaryItem {
        @ExcelProperty("表名")
        private String collectionName;
        @ExcelProperty("字段名")
        private String fieldName;
        @ExcelProperty("字段类型")
        private String fieldType;
        @ExcelProperty("注释")
        private String comment;
    }


}
