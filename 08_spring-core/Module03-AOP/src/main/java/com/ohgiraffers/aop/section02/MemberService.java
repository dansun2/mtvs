package com.ohgiraffers.aop.section02;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MemberService {

    private Map<String, Member> memberRepository = new HashMap<String, Member>();

    public void registerMember(Member member) {
        if (member.getEmail() == null || member.getEmail().isEmpty()) {
            throw new IllegalArgumentException("이메일은 필수입니다.");
        }

        if (member.getPassword() == null || member.getPassword().isEmpty()) {
            throw new IllegalArgumentException("비밀번호는 필수입니다.");
        }

        if (member.getPassword().length() < 8) {
            throw new IllegalArgumentException("비밀번호는 8글자 이상이어야 합니다.");
        }

        if (memberRepository.containsKey(member.getEmail())) {
            throw new IllegalArgumentException("이미 등록된 이메일입니다. : " + member.getEmail());
        }

        memberRepository.put(member.getEmail(), member);
        // 비즈니스 로직 종료
    }

    public Member getMember(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("이메일을 입력해주세요.");
        }

        Member member = memberRepository.get(email);
        if (member == null) {
            throw new IllegalArgumentException("존재하지 않는 회원입니다. : " + email);
        }
        //핵심 로직은 종료

        return member;
    }

    public void updatePassword(String email, String currentPassword, String newPassword) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("이메일은 필수입니다."); // 원래는 이런것들도 다 로그를 남겨줘야함. 어떤 오류가 자주 발생하는지 보기 위해
        }

        if (currentPassword == null || currentPassword.isEmpty()) {
            throw new IllegalArgumentException("현재 비밀번호는 필수입니다."); // 원래는 이런것들도 다 로그를 남겨줘야함. 어떤 오류가 자주 발생하는지 보기 위해
        }

        if (newPassword == null || newPassword.isEmpty()) {
            throw new IllegalArgumentException("변경할 비밀번호는 필수입니다."); // 원래는 이런것들도 다 로그를 남겨줘야함. 어떤 오류가 자주 발생하는지 보기 위해
        }

        if (newPassword.length() < 8) {
            throw new IllegalArgumentException("비밀번호는 8글자 이상이어야 합니다.");
        }

        Member member = memberRepository.get(email);

        if (member == null) {
            throw new IllegalArgumentException("존재하지 않는 회원입니다. : " + email);
        }

        if (!member.getPassword().equals(currentPassword)) {
            throw new IllegalArgumentException("현재 비밀번호와 일치하지 않습니다.");
        }

        member.setPassword(newPassword);
        memberRepository.put(email, member);
        //비즈니스 로직 종료
    }

    public void deleteMember(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("이메일을 입력해주세요.");
        }

        if (!memberRepository.containsKey(email)) {
            throw new IllegalArgumentException("존재하지 않는 회원입니다. : " + email);
        }
        // 회원 삭제
        memberRepository.remove(email);

        // 성능 측정
        long startTime = System.currentTimeMillis();
        
        try {
            // 트랜잭션 처리 해야됨
            System.out.println("====== 트랜잭션 스타트 ======");
            if (member.getEmail() == null || member.getEmail().isEmpty()) {
                throw new IllegalArgumentException("이메일은 필수입니다.");
            }

            if (member.getPassword() == null || member.getPassword().isEmpty()) {
                throw new IllegalArgumentException("비밀번호는 필수입니다.");
            }

            if (member.getPassword().length() < 8) {
                throw new IllegalArgumentException("비밀번호는 8글자 이상이어야 합니다.");
            }

            if(memberRepository.containsKey(member.getEmail())) {
                throw new IllegalArgumentException("이미 등록된 이메일입니다. : " + member.getEmail());
            }

            memberRepository.put(member.getEmail(), member);
            // 비즈니스 로직 종료

            // 커밋 처리 해야됨
            System.out.println("====== 트랜잭션 커밋 ======");
        } catch (Exception e) {
            // 롤백 처리 해야됨
            System.out.println("[로그] - 오류 발생");
            System.out.println("====== 트랜잭션 롤백 ======");
            throw new RuntimeException(e);
        } finally {
            long endTime = System.currentTimeMillis();
            // 성능 측정
            System.out.println("[성능] 회원가입 처리 시간 : " + (endTime - startTime) + "ms");
        }
    }

    public Member getMember(String email) {
        long startTime = System.currentTimeMillis();

        try {
            if (email == null || email.isEmpty()) {
                throw new IllegalArgumentException("이메일을 입력해주세요.");
            }

            Member member = memberRepository.get(email);
            if (member == null) {
                throw new IllegalArgumentException("존재하지 않는 회원입니다. : " + email);
            }
            //핵심 로직은 종료

            return member;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println("[성능] 회원조회 처리 시간 : " + (endTime - startTime) + "ms");
        }
    }

    public void updatePassword(String email, String currentPassword, String newPassword) {
        // 성능측정
        long startTime = System.currentTimeMillis();
        try {
            // 커밋
            System.out.println("[로그] 비밀번호 변경 시작 : " + email);
            // 트랜잭션 시작
            System.out.println("[트랜잭션] 스타트");
            if (email == null || email.isEmpty()) {
                throw new IllegalArgumentException("이메일은 필수입니다."); // 원래는 이런것들도 다 로그를 남겨줘야함. 어떤 오류가 자주 발생하는지 보기 위해
            }

            if (currentPassword == null || currentPassword.isEmpty()) {
                throw new IllegalArgumentException("현재 비밀번호는 필수입니다."); // 원래는 이런것들도 다 로그를 남겨줘야함. 어떤 오류가 자주 발생하는지 보기 위해
            }

            if (newPassword == null || newPassword.isEmpty()) {
                throw new IllegalArgumentException("변경할 비밀번호는 필수입니다."); // 원래는 이런것들도 다 로그를 남겨줘야함. 어떤 오류가 자주 발생하는지 보기 위해
            }

            if (newPassword.length() < 8) {
                throw new IllegalArgumentException("비밀번호는 8글자 이상이어야 합니다.");
            }

            Member member = memberRepository.get(email);

            if (member == null) {
                throw new IllegalArgumentException("존재하지 않는 회원입니다. : " + email);
            }

            if (!member.getPassword().equals(currentPassword)) {
                throw new IllegalArgumentException("현재 비밀번호와 일치하지 않습니다.");
            }

            member.setPassword(newPassword);
            memberRepository.put(email, member);
            //비즈니스 로직 종료

            // 트랜잭션 커밋
            System.out.println("[트랜잭션] 커밋");
        } catch (Exception e) {
            // 롤백
            System.out.println("[트랜잭션] 롤백");
            throw new RuntimeException(e);
        } finally {
            // 성능측정
            long endTime = System.currentTimeMillis();
            System.out.println("[성능] " + (endTime - startTime) + "ms");
        }
    }

    public void deleteMember(String email) {
        long startTime = System.currentTimeMillis();

        try {
            // 트랜잭션
            System.out.println("[트랜잭션] 시작");

            if (email == null || email.isEmpty()) {
                throw new IllegalArgumentException("이메일을 입력해주세요.");
            }

            if (!memberRepository.containsKey(email)) {
                throw new IllegalArgumentException("존재하지 않는 회원입니다. : " + email);
            }
            // 회원 삭제
            memberRepository.remove(email);

            // 트랜잭션
            System.out.println("[트랜잭션] 커밋");
        } catch (Exception e) {

            // 트랜잭션
            System.out.println("[트랜잭션] 롤백");
            throw new RuntimeException(e);
        } finally {
            long endTime = System.currentTimeMillis();
            // 성능 측정
            System.out.println("[성능] " + (endTime - startTime) + "ms");
        }
    }
}
