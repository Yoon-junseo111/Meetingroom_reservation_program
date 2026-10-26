import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // 사용자로부터 메뉴 번호, 예약자 이름,
        // 회의실 번호, 예약 날짜 등을 입력받기 위한 Scanner 생성
        Scanner scanner = new Scanner(System.in);

        // 회의실 정보를 저장하는 배열
        // 현재는 테스트를 위해 회의실 3개를 미리 등록
        Room[] rooms = {
            new Room(1, "회의실 A", 10),
            new Room(2, "회의실 B", 20),
            new Room(3, "회의실 C", 30)
        };

        // 예약 정보를 저장하기 위한 Reservation 배열 생성
        // 최대 5개의 예약을 저장할 수 있도록 구성
        Reservation[] reservations = new Reservation[6];

        // 현재 등록된 예약의 개수를 저장하는 변수
        // 처음에는 예약이 없으므로 0으로 시작
        int reservationCount = 0;

        // 프로그램이 종료될 때까지 메뉴를 계속 보여주기 위한 반복문
        while (true) {

            // 메뉴를 보기 좋게 구분하기 위한 빈 줄 출력
            System.out.println();

            // 프로그램 제목 출력
            System.out.println("================================");
            System.out.println("   회의실 예약 관리 시스템");
            System.out.println("================================");

            // 사용자에게 사용할 수 있는 메뉴 출력
            System.out.println("1. 회의실 조회");
            System.out.println("2. 예약 등록");
            System.out.println("3. 예약 조회");
            System.out.println("4. 예약 취소");
            System.out.println("5. 프로그램 종료");

            // 사용자에게 메뉴 번호 입력 요청
            System.out.print("메뉴를 선택하세요: ");

            // 사용자가 입력한 메뉴 번호를 menu 변수에 저장
            int menu = scanner.nextInt();

            // 사용자가 선택한 메뉴 번호에 따라 기능 실행
            switch (menu) {

                case 1:

                    // 회의실 조회 기능의 제목 출력
                    System.out.println("=== 회의실 목록 ===");

                    // rooms 배열에 저장된 모든 회의실 정보를
                    // 하나씩 가져와서 출력
                    for (Room room : rooms) {
                        room.showInfo();
                    }

                    // 회의실 조회 기능 종료
                    break;


                case 2:

                    // 예약 등록 기능의 제목 출력
                    System.out.println("=== 예약 등록 ===");

                    // 예약 배열이 가득 찼는지 확인
                        if (reservationCount >= reservations.length) {
                            System.out.println();
                            System.out.println("예약 가능 개수를 초과했습니다.");
                            System.out.println("최대 예약 개수는 6개입니다.");
                            System.out.println();
                            break;
                        }

                    // 사용자에게 예약자 이름을 입력받음
                    // 입력한 이름은 userName 변수에 저장
                    System.out.print("예약자 이름: ");
                    String userName = scanner.next();

                  
                    // 사용자에게 예약할 회의실 번호를 입력받음
                    int roomId;

                    // 입력한 번호가 실제로 등록된 회의실인지 확인하기 위한 변수
                    boolean roomExists;

                    // 올바른 회의실 번호를 입력할 때까지 반복
                    while (true) {

                        System.out.print("회의실 번호: ");
                        roomId = scanner.nextInt();

                        // 처음에는 회의실이 존재하지 않는다고 설정
                        roomExists = false;

                        // 등록된 회의실 목록을 하나씩 확인
                        for (Room room : rooms) {

                            // 입력한 번호와 회의실 번호가 일치하는지 확인
                            // Room 클래스에 getId() 메서드가 있어야 사용할 수 있음
                            if (room.getId() == roomId) {
                                roomExists = true;
                                break;
                            }
                        }

                        // 회의실이 존재하면 입력 반복 종료
                        if (roomExists) {
                            break;
                        }

                        // 등록되지 않은 회의실 번호라면 안내 메시지 출력
                        System.out.println("존재하지 않는 회의실 번호입니다. 다시 입력해주세요.");
                    }


                    // 사용자에게 예약 날짜를 입력받음
                    // 실제로 존재하는 날짜인지 확인
                    String date;

                    while (true) {

                        // 날짜 입력 요청
                        System.out.print("예약 날짜 (예: 2026-10-12): ");
                        date = scanner.next();

                        try {

                            // 입력한 문자열을 날짜 형식으로 변환
                            // 형식이 잘못되었거나 존재하지 않는 날짜라면 오류 발생
                            LocalDate.parse(date);

                            // 날짜 변환에 성공하면 반복문 종료
                            break;

                        } catch (DateTimeParseException e) {

                            // 날짜 형식이 잘못되었거나 유효하지 않은 경우
                            System.out.println(
                                "잘못된 날짜입니다. YYYY-MM-DD 형식으로 다시 입력해주세요."
                            );
                        }
                    }
                    
                    // 예약 시작 시간 입력
                    String startTime;

                    while (true) {
                        System.out.print("예약 시작 시간 (예: 09:00): ");
                        startTime = scanner.next();

                        try {
                            java.time.LocalTime.parse(startTime);
                            break;
                        } catch (java.time.format.DateTimeParseException e) {
                            System.out.println(
                                "잘못된 시간입니다. HH:mm 형식으로 입력해주세요."
                            );
                        }
                    }

                    // 예약 종료 시간 입력
                    String endTime;

                    while (true) {
                        System.out.print("예약 종료 시간 (예: 10:00): ");
                        endTime = scanner.next();

                        try {
                            java.time.LocalTime.parse(endTime);

                            // 종료 시간이 시작 시간보다 늦은지 확인
                            if (java.time.LocalTime.parse(endTime)
                                    .isAfter(java.time.LocalTime.parse(startTime))) {
                                break;
                            }

                            System.out.println(
                                "종료 시간은 시작 시간보다 늦어야 합니다."
                            );

                        } catch (java.time.format.DateTimeParseException e) {
                            System.out.println(
                                "잘못된 시간입니다. HH:mm 형식으로 입력해주세요."
                            );
                        }
                    }

                    // 같은 회의실, 같은 날짜에 시간이 겹치는 예약이 있는지 확인
                    boolean duplicateReservation = false;

                    for (int i = 0; i < reservationCount; i++) {

                        // 회의실 번호와 날짜가 같은 예약만 확인
                        if (reservations[i].getRoomId() == roomId
                                && reservations[i].getDate().equals(date)) {

                            // 기존 예약의 시작 시간과 종료 시간
                            java.time.LocalTime existingStart =
                                java.time.LocalTime.parse(
                                    reservations[i].getStartTime()
                                );

                            java.time.LocalTime existingEnd =
                                java.time.LocalTime.parse(
                                    reservations[i].getEndTime()
                                );

                            // 예약 시간이 겹치는지 확인
                            java.time.LocalTime newStart =
                                java.time.LocalTime.parse(startTime);

                            java.time.LocalTime newEnd =
                                java.time.LocalTime.parse(endTime);

                            if (newStart.isBefore(existingEnd)
                                    && newEnd.isAfter(existingStart)) {

                                duplicateReservation = true;
                                break;
                            }
                        }
                    }

                    // 예약 시간이 겹치면 등록하지 않음
                    if (duplicateReservation) {
                        System.out.println(
                            "해당 시간에는 이미 예약이 있습니다."
                        );
                        break;
                    }

                    // 예약 객체 생성
                    Reservation reservation = new Reservation(
                        reservationCount + 1,
                        userName,
                        roomId,
                        date,
                        startTime,
                        endTime
                    );

                    // 예약 배열에 저장
                    reservations[reservationCount] = reservation;

                    // 예약 개수 증가
                    reservationCount++;

                    // 예약 등록 완료 메시지
                    System.out.println();
                    System.out.println("예약이 등록되었습니다.");

                    // 예약 등록 기능 종료
                    break;


                case 3:

                    // 예약 조회 기능의 제목 출력
                    System.out.println("=== 예약 목록 ===");

                    // 등록된 예약이 하나도 없는 경우
                    if (reservationCount == 0) {
                        System.out.println("등록된 예약이 없습니다.");
                        break;
                    }

                    // 예약 배열에 저장된 예약 정보를 처음부터 하나씩 조회
                    // reservationCount는 현재 등록된 예약의 개수를 의미
                    for (int i = 0; i < reservationCount; i++) {

                        // Reservation 객체의 showInfo() 메서드를 호출하여
                        // 예약 번호, 예약자, 회의실, 날짜를 화면에 출력
                        reservations[i].showInfo();
                    }

                    // 예약 조회 기능 종료
                    break;


                case 4:

                    // 예약 취소 기능의 제목 출력
                    System.out.println("=== 예약 취소 ===");

                    // 등록된 예약이 하나도 없는 경우
                    if (reservationCount == 0) {
                        System.out.println("취소할 예약이 없습니다.");
                        break;
                    }

                    // 사용자에게 취소할 예약 번호 입력 요청
                    System.out.print("취소할 예약 번호: ");
                    int cancelId = scanner.nextInt();

                    // 취소할 예약의 배열 위치를 저장하는 변수
                    // -1은 아직 예약을 찾지 못했다는 의미
                    int cancelIndex = -1;

                    // 등록된 예약을 처음부터 하나씩 확인
                    for (int i = 0; i < reservationCount; i++) {

                        // 입력한 예약 번호와
                        // 현재 예약의 예약 번호가 같은지 확인
                        if (reservations[i].getId() == cancelId) {

                            // 일치하는 예약의 배열 위치 저장
                            cancelIndex = i;

                            // 예약을 찾았으므로 반복문 종료
                            break;
                        }
                    }

                    // 입력한 예약 번호에 해당하는 예약을 찾지 못한 경우
                    if (cancelIndex == -1) {
                        System.out.println("해당 예약을 찾을 수 없습니다.");
                        break;
                    }

                    // 취소한 예약 뒤에 있는 예약들을
                    // 한 칸씩 앞으로 이동
                    for (int i = cancelIndex; i < reservationCount - 1; i++) {
                        reservations[i] = reservations[i + 1];
                    }

                    // 마지막에 남은 배열 위치를 비움
                    reservations[reservationCount - 1] = null;

                    // 예약 개수를 1 감소
                    reservationCount--;

                    // 예약 취소 완료 메시지 출력
                    System.out.println("예약이 취소되었습니다.");

                    break;

                case 5:

                    // 프로그램 종료 메시지 출력
                    System.out.println("프로그램을 종료합니다.");

                    // Scanner 사용 종료
                    scanner.close();

                    // main 메서드를 종료하여 프로그램 종료
                    return;


                default:

                    // 1~5 이외의 번호를 입력했을 경우
                    // 잘못된 메뉴라는 메시지 출력
                    System.out.println("잘못된 메뉴입니다.");
            }
        }
    }
}
