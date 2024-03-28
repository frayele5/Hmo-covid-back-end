package com.example.hmo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/members")
@CrossOrigin("*")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers(){
        return new ResponseEntity<List<Member>>(memberService.allMembers(), HttpStatus.OK);
    }

    @GetMapping({"/{identityCard}"})
    public ResponseEntity<Optional<Member>> getSingleMember(@PathVariable long identityCard){
        return new ResponseEntity<Optional<Member>>(memberService.singleMember(identityCard), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Member> addMember(@RequestBody Member member) {
        if (memberService.isIdentityCardExists(member.getIdentityCard())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Member with this identity card already exists");
        }
        memberService.addMember(member);
        return new ResponseEntity<>(member, HttpStatus.CREATED);
    }

    @DeleteMapping("/{identityCard}")
    public ResponseEntity<Void> deleteMember(@PathVariable long identityCard) {
        Optional<Member> existingMember = memberService.singleMember(identityCard);
        if (existingMember.isPresent()) {
            memberService.deleteMember(identityCard);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{identityCard}")
    public ResponseEntity<Member> updateMember(@PathVariable long identityCard, @RequestBody Member updatedMember) {
        Optional<Member> existingMemberOptional = memberService.singleMember(identityCard);
        if (existingMemberOptional.isPresent()) {
            Member existingMember = existingMemberOptional.get();
            existingMember.setFirstName(updatedMember.getFirstName());
            existingMember.setLastName(updatedMember.getLastName());
            existingMember.setIdentityCard(updatedMember.getIdentityCard());
            existingMember.setAddress(updatedMember.getAddress());
            existingMember.setBirthDate(updatedMember.getBirthDate());
            existingMember.setPhone(updatedMember.getPhone());
            existingMember.setCellPhone(updatedMember.getCellPhone());
            existingMember.getCovidInformation().setVaccineDates(updatedMember.getCovidInformation().getVaccineDates());
            existingMember.getCovidInformation().setVaccineManufacturers(updatedMember.getCovidInformation().getVaccineManufacturers());
            existingMember.getCovidInformation().setPositiveResultDate(updatedMember.getCovidInformation().getPositiveResultDate());
            existingMember.getCovidInformation().setRecoveryDate(updatedMember.getCovidInformation().getRecoveryDate());
            memberService.updateMember(existingMember);
            return new ResponseEntity<>(existingMember, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<String> handleDuplicateIdentityCard(ResponseStatusException ex) {
        return new ResponseEntity<>(ex.getReason(), ex.getStatus());
    }
}