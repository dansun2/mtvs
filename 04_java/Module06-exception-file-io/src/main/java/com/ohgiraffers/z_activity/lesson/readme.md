**미션 1: 도서 및 회원 정보를 파일에 저장하는 기능 구현**
- **입력:**
    - 도서 정보를 담은 Book 객체 리스트
    - 회원 정보를 담은 Member 객체 리스트
- **기능:**
    1. Book 객체와 Member 객체의 정보를 파일(예: "books.txt", "members.txt")에 저장한다.
    2. 파일 입출력 과정에서 발생할 수 있는 예외를 처리하여, 파일 저장 실패 시 적절한 메시지를 출력한다.
- **출력 예:**
    - "books.txt" 파일에 각 도서의 정보가 한 줄씩 저장됨
    - "members.txt" 파일에 각 회원의 정보가 한 줄씩 저장됨

<개발 순서>  
**미션 1 (도서 및 회원 정보 파일 저장):**
1. `Book` 클래스를 정의하여 private 멤버 변수(title, author, price)를 선언하고, 생성자, getter, toString() 메서드를 구현한다.
2. `Member` 클래스를 정의하여 private 멤버 변수(name, membershipId)를 선언하고, 생성자, getter, toString() 메서드를 구현한다.
3. `FileStorageManager` 클래스를 정의하여:
    - `saveBooksToFile(List<Book> books, String filePath)` 메서드 구현 (파일에 각 도서 정보를 한 줄씩 저장)
    - `saveMembersToFile(List<Member> members, String filePath)` 메서드 구현 (파일에 각 회원 정보를 한 줄씩 저장)
    - 파일 입출력 시 발생하는 IOException을 try-catch로 처리한다.
4. main() 메서드에서 샘플 데이터를 이용하여 파일 저장 기능을 시연한다.