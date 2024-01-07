package org.example;

import java.sql.Connection;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DataManager {
    private DDLService ddlService;
    private DMLService dmlService;
    private DQLService dqlService;
    private Scanner in;

    public DataManager() {
        Connection conn = SQLiteManager.getInstance().getConnection();
        this.ddlService = new DDLService(conn);
        this.dmlService = new DMLService(conn);
        this.dqlService = new DQLService(conn);
        this.in = new Scanner(System.in);

        ddlService.createTable();
    }

    public void createData() {
        System.out.println();
        System.out.print("종류를 입력하세요. (아우터, 상의, 하의, 기타) : ");
        String type=in.nextLine();
        System.out.print("이름을 입력하세요. : ");
        String name=in.nextLine();
        System.out.print("가격을 입력하세요. : ");
        String priceStr = in.nextLine();
        int price = Integer.parseInt(priceStr);
        System.out.print("설명을 입력하세요. : ");
        String description=in.nextLine();

        ClothingData data = new ClothingData(0, type, name, price, description);
        dmlService.insertData(data);
        System.out.println("데이터가 성공적으로 생성되었습니다.\n");
    }

    public void readData() {
        List<ClothingData> dataList = dqlService.getData();
        displayDataList(dataList);
    }

    public void updateData() {
        readData();
        System.out.print("수정할 데이터의 번호를 입력하세요. : ");
        int id = Integer.parseInt(in.nextLine());
        System.out.print("새로운 종류를 입력하세요. (아우터, 상의, 하의, 기타) : ");
        String type = in.nextLine();
        System.out.print("새로운 이름을 입력하세요. : ");
        String name = in.nextLine();
        System.out.print("새로운 가격을 입력하세요. : ");
        int price = Integer.parseInt(in.nextLine());
        System.out.print("새로운 설명을 입력하세요. : ");
        String description = in.nextLine();

        ClothingData data = new ClothingData(id, type, name, price, description);
        dmlService.updateData(data);
        System.out.println("데이터가 성공적으로 업데이트되었습니다.\n");
    }

    public void deleteData() {
        readData();
        System.out.print("삭제할 데이터의 번호를 입력하세요. : ");
        int id = Integer.parseInt(in.nextLine());

        dmlService.deleteData(id);
        System.out.println("데이터가 성공적으로 삭제되었습니다.\n");
    }

    public void searchType() {
        System.out.print("검색할 종류를 입력하세요 : ");
        String searchType = in.nextLine();

        List<ClothingData> dataList = dqlService.getDataByType(searchType);
        if (dataList.isEmpty()) {
            System.out.println("종류가 " + searchType + "인 데이터를 찾을 수 없습니다.\n");
            return;
        }

        displayDataList(dataList);
    }

    public void sortData() {
        System.out.print("정렬 기준을 선택해주세요. (1: 이름, 2: 가격) : ");
        int sortChoice = in.nextInt();
        in.nextLine();

        String sortBy = sortChoice == 1 ? "name" : "price";
        List<ClothingData> dataList = dqlService.getSortedData(sortBy);

        displayDataList(dataList);
    }

    private void displayDataList(List<ClothingData> dataList) {
        if (dataList.isEmpty()) {
            System.out.println("데이터가 없습니다.\n");
            return;
        }

        System.out.println("                  *   데이터 목록   *                  ");
        System.out.println("==========================================================");
        System.out.printf("%-6s %-10s %-10s %-10s %-21s\n", "번호", "이름", "종류", "가격", "설명");
        System.out.println("==========================================================");
        for (ClothingData data : dataList) {
            System.out.println(data);
        }
        System.out.println("----------------------------------------------------------");
        System.out.println();
    }
}
