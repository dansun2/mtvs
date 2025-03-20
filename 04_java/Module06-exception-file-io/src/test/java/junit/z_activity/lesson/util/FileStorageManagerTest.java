package junit.z_activity.lesson.util;

import com.ohgiraffers.z_activity.lesson.model.Book;
import com.ohgiraffers.z_activity.lesson.model.Member;
import com.ohgiraffers.z_activity.lesson.util.FileStorageManager;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileStorageManagerTest {
    List<Book> books = new ArrayList<>();
    List<Member> members = new ArrayList<>();
    private static Path booksFile;
    private static Path membersFile;


    @BeforeAll
    static void setUp() throws IOException {
        booksFile = Files.createTempFile("test_books", ".txt");
        membersFile = Files.createTempFile("test_members", ".txt");
    }

    @BeforeEach
    void createFile(){
        books.add(new Book("Test Book 1", "Author A", 30.0));
        books.add(new Book("Test Book 2", "Author B", 40.0));
        members.add(new Member("Test Member 1", "TM001"));
        members.add(new Member("Test Member 2", "TM002"));
    }


    @Test
    public void testSaveBooksToFile() throws IOException {
        FileStorageManager.saveBooksToFile(books, booksFile.toString());
        List<String> lines = Files.readAllLines(booksFile);
        assertEquals(2, lines.size());
        assertTrue(lines.get(0).contains("Test Book 1"));
        assertTrue(lines.get(1).contains("Test Book 2"));
    }

    @Test
    public void testSaveMembersToFile() throws IOException {
        FileStorageManager.saveMembersToFile(members, membersFile.toString());
        List<String> lines = Files.readAllLines(membersFile);
        assertEquals(2, lines.size());
        assertTrue(lines.get(0).contains("Test Member 1"));
        assertTrue(lines.get(1).contains("Test Member 2"));
    }

    @Test
    public void testSaveBooksToFile_InvalidPath() {
        // 잘못된 파일 경로를 지정하여 IOException 발생 여부 확인
        List<Book> books = List.of(new Book("Invalid Path Book", "Author X", 20.0));
        assertDoesNotThrow(() -> {
            FileStorageManager.saveBooksToFile(books, "///invalid_path///books.txt");
        });
    }

    @AfterEach
    void tearDown() {
        books = null;
        members = null;
    }

    @AfterAll
    static void tearDownAll() throws IOException {
        Files.deleteIfExists(booksFile);
        Files.deleteIfExists(membersFile);
    }
}