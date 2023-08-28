package party.people.web.controller.place;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import party.people.domain.InviteCard;
import party.people.domain.Place;
import party.people.domain.SearchInput;
import party.people.domain.SearchResult;
import party.people.repository.InviteCard.InviteCardInterface;
import party.people.repository.place.PlaceInterface;
import party.people.repository.search.SearchInputInterface;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class placeSaveController {
    private final PlaceInterface placeInterface;
    private final SearchInputInterface searchInputInterface;
    private final InviteCardInterface inviteCardInterface;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PostMapping("saveCard")
    public String inviteCard(@ModelAttribute("inviteCard")InviteCard inviteCard,@RequestParam("datetype") String datetype){

        System.out.println("저장중");
        System.out.println(inviteCard.getPLACE_ID_1());

        InviteCard letInviteCard = new InviteCard();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        String dateOn =datetype.split(",")[0];
        letInviteCard.setTITLE(inviteCard.getTITLE().split(",")[0]);
        letInviteCard.setMEETING_CONTENT(inviteCard.getMEETING_CONTENT().split(",")[0]);

        try {
            letInviteCard.setTAGET_DATE(formatter.parse(datetype));
        }
        catch (Exception e){
            log.info("잘못된 날짜입력");
        }





        log.info("placeSaveController] datetype = " + datetype);

        log.info("placeSaveController] inviteCard = " + inviteCard.getTITLE());
        log.info("placeSaveController] inviteCard = " + inviteCard.getPLACE_ID_1());

        log.info("placeSaveController] inviteCard = " + inviteCard.getCLIENT_ID());

        inviteCard.setCLIENT_ID("tester");
        inviteCardInterface.saveCard(inviteCard);


        return "redirect:/invite/invite_A";
    }




//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @PostMapping("saveCard")
////    public String inviteCard(@ModelAttribute("inviteCard")InviteCard inviteCard,@RequestParam("datetype") String datetype){
//
//    public String inviteCard(@RequestParam("MEETING_PARTICIPANTS")String MEETING_PARTICIPANTS,@@RequestParam(""),@RequestParam(""),@RequestParam(""),
//                             @RequestParam("datetype") String datetype ){
//        System.out.println("저장중");
//        System.out.println(inviteCard.getPLACE_ID_1());
//
//        log.info("placeSaveController] datetype = " + datetype);
//
//        log.info("placeSaveController] inviteCard = " + inviteCard.getTITLE());
//        log.info("placeSaveController] inviteCard = " + inviteCard.getPLACE_ID_1());
//
//        log.info("placeSaveController] inviteCard = " + inviteCard.getCLIENT_ID());
//
//        inviteCard.setCLIENT_ID("tester");
//        inviteCardInterface.saveCard(inviteCard);
//
//
//        return "redirect:/invite/invite_A";
//    }
    @GetMapping("saveCard")
    public String inviteGet(){
        return "invite/invite_A";
    }




}
