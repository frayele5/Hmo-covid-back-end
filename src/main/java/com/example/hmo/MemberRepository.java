package com.example.hmo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends MongoRepository<Member, ObjectId> {

    Optional<Member> findMemberByIdentityCard(Long identityCard);
    void deleteMemberByIdentityCard(Long identityCard);
}
