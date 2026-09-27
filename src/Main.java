import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // 사용자 입력을 받기 위한 Scanner 생성
        Scanner scanner = new Scanner(System.in);

        Room[] rooms = {
            new Room(1, "회의실 A", 10),
            new Room(2, "회의실 B", 20),
            new Room(3, "회의실 C", 30)
        };

        // 프로그램이 종료될 때까지 반복
        while (true) {

            System.out.println();
            System.out.println("================================");
            System.out.println("   회의실 예약 관리 시스템");
            System.out.println("================================");

            System.out.println("1. 회의실 조회");
            System.out.println("2. 예약 등록");
            System.out.println("3. 예약 조회");
            System.out.println("4. 예약 취소");
            System.out.println("5. 프로그램 종료");

            System.out.print("메뉴를 선택하세요: ");

            // 사용자가 입력한 메뉴 번호 저장
            int menu = scanner.nextInt();

            // 메뉴에 따라 기능 실행
            switch (menu) {

                case 1:
                    System.out.println("회의실 조회를 선택했습니다.");

                    for (Room room : rooms) {
                        room.showInfo();
                    }

                    break;

                case 2:
                    System.out.println("=== 예약 등록 ===");

                    System.out.print("예약자 이름: ");
                    String userName = scanner.next();

                    System.out.print("회의실 번호: ");
                    int roomId = scanner.nextInt();

                    System.out.print("예약 날짜: ");
                    String date = scanner.next();

                    System.out.println();
                    System.out.println("예약이 등록되었습니다.");
                    System.out.println("예약자: " + userName);
                    System.out.println("회의실: " + roomId);
                    System.out.println("예약 날짜: " + date);

                    break;

                case 3:
                    System.out.println("예약 조회를 선택했습니다.");
                    break;

                case 4:
                    System.out.println("예약 취소를 선택했습니다.");
                    break;

                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;

                default:
                    System.out.println("잘못된 메뉴입니다.");
            }
        }
    }
}