package com.example.hmo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public List<Member> allMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> singleMember(long identityCard) {
        return memberRepository.findMemberByIdentityCard(identityCard);
    }

    public void addMember(Member member) {
        memberRepository.save(member);
    }

    public void deleteMember(long identityCard) {
        memberRepository.deleteMemberByIdentityCard(identityCard);
    }

    public void updateMember(Member updatedMember) {
        memberRepository.save(updatedMember);
    }

    public boolean isIdentityCardExists(long identityCard) {
        Optional<Member> existingMember = memberRepository.findMemberByIdentityCard(identityCard);
        return existingMember.isPresent();
    }
}