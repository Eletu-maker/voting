import VotingPlatfrom.Admin;
import VotingPlatfrom.Voter;
import VotingPlatfrom.Voting;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VotingTest {

    @Test
    public void test_vottingAddAdim(){
        Voting voting = new Voting();
        voting.addAdmin("usman","1234");

        assertEquals(voting.getAdmins().size(),1);



    }

    @Test
    public void testCantAddSameData(){
        Voting voting = new Voting();
        voting.addAdmin("usman","1234");
        voting.addAdmin("usman","1234");

        assertEquals(voting.getAdmins().size(),1);



    }


    @Test
    public void testAddMultipleAdims(){
        Voting voting = new Voting();
        voting.addAdmin("usman","1234");
        voting.addAdmin("elety","piqo");
        voting.addAdmin("garaz","0305");

        assertEquals(voting.getAdmins().size(),3);



    }

    @Test
    public void testThatRemoveWork(){
        Voting voting = new Voting();
        voting.addAdmin("usman","1234");
        voting.addAdmin("elety","piqo");
        voting.addAdmin("garaz","0305");
        voting.removeAdmin("elety","piqo");

        assertEquals(voting.getAdmins().size(),2);

    }


    @Test
    public void testFindAdim(){
        Voting voting = new Voting();
        voting.addAdmin("usman","1234");
        voting.addAdmin("elety","piqo");
        voting.addAdmin("garaz","0305");
        String link = voting.findAdmin("usman","1234").getLink();


        assertEquals("name: usman/n title: /n link: "+link+"/n parties: 0",voting.findAdmin("usman","1234").toString());
    }


    @Test
    public void testFindAdimNull(){
        Voting voting = new Voting();
        voting.addAdmin("usman","1234");
        voting.addAdmin("elety","piqo");
        voting.addAdmin("garaz","0305");


        assertNull(voting.findAdmin("usman","12345"));
    }

    @Test
    public void testAdimPassword(){
        Voting voting = new Voting();
        voting.addAdmin("usman","1234");
        voting.addAdmin("elety","piqo");
        voting.addAdmin("garaz","0305");
        Admin person=  voting.findAdmin("usman","1234");
        assertFalse(person.checkPassword("75sty"));

    }

    @Test
    public void testAdimPassword2(){
        Voting voting = new Voting();
        voting.addAdmin("usman","1234");
        voting.addAdmin("elety","piqo");
        voting.addAdmin("garaz","0305");
        Admin person=  voting.findAdmin("usman","1234");
        assertTrue(person.checkPassword("1234"));

    }

    @Test
    public void testAdimLink(){
        Voting voting = new Voting();
        voting.addAdmin("usman","1234");
        voting.addAdmin("elety","piqo");
        voting.addAdmin("garaz","0305");
        Admin person=  voting.findAdmin("usman","1234");
        assertEquals(person.getLink().length(),5);

    }


    @Test
    public void testAdimtitle(){
        Voting voting = new Voting();
        voting.addAdmin("usman","1234");
        voting.addAdmin("elety","piqo");
        voting.addAdmin("garaz","0305");
        Admin person=  voting.findAdmin("usman","1234");
        assertEquals(person.getTitle(),"");
        person.setTitle("voting for president");
        assertEquals(person.getTitle(),"voting for president");

    }


    @Test
    public void testAdimpool(){
        Voting voting = new Voting();
        voting.addAdmin("usman","1234");
        voting.addAdmin("elety","piqo");
        voting.addAdmin("garaz","0305");
        Admin person=  voting.findAdmin("usman","1234");
        List <String> parties= new ArrayList<>();
        parties.add("apc");
        parties.add("pdp");
        parties.add("nop");
        person.createPool(parties);
        assertEquals(person.getPool().size(),3);


    }


    @Test
    public void testVoter(){
        Voting voting = new Voting();
        voting.addVoter("korede","1701");


        assertEquals(voting.getVoters().size(),1);
    }



    @Test
    public void testVotersamedata(){
        Voting voting = new Voting();
        voting.addVoter("korede","1701");
        voting.addVoter("korede","1701");


        assertEquals(voting.getVoters().size(),1);
    }


    @Test
    public void testAddMultipleVoter(){
        Voting voting = new Voting();
        voting.addVoter("korede","1701");
        voting.addVoter("usman","1234");

        voting.addVoter("elety","piqo");
        voting.addVoter("garaz","0305");

        assertEquals(voting.getVoters().size(),4);

    }


    @Test
    public void findVoter(){
        Voting voting = new Voting();
        voting.addVoter("korede","1701");
        voting.addVoter("usman","1234");
        voting.addVoter("elety","piqo");
        voting.addVoter("garaz","0305");

        assertEquals(voting.findVoter("korede","1701").toString(),"name: korede");
    }


    @Test
    public void findVoterNull(){
        Voting voting = new Voting();
        voting.addVoter("korede","1701");
        voting.addVoter("usman","1234");
        voting.addVoter("elety","piqo");
        voting.addVoter("garaz","0305");

        assertNull(voting.findVoter("korede","17018"));
    }



    @Test
    public void testVoterPassword(){
        Voting voting = new Voting();
        voting.addVoter("korede","1701");
        voting.addVoter("usman","1234");
        voting.addVoter("elety","piqo");
        voting.addVoter("garaz","0305");

        Voter voter = voting.findVoter("korede","1701");


        assertFalse( voter.checkPassword("ftuvs"));
        assertTrue( voter.checkPassword("1701"));

    }


    @Test
    public void testVoterLink(){
        Voting voting = new Voting();
        voting.addAdmin("usman","1234");
        voting.addAdmin("elety","piqo");
        voting.addAdmin("garaz","0305");
        voting.addVoter("elety","piqo");
        voting.addVoter("garaz","0305");
        Admin person=  voting.findAdmin("usman","1234");

        person.setTitle("voting for president");
        List <String> parties= new ArrayList<>();
        parties.add("apc");
        parties.add("pdp");
        parties.add("nop");
        person.createPool(parties);
        Voter voter = voting.findVoter("elety","piqo");
        Voter voter1 = voting.findVoter("garaz","0305");
        String link = person.getLink();
        voter1.vote("apc",link,voting,person);
        voter.vote("apc",link,voting,person);

        assertEquals(  voter.getvoting(link,voting).get("nop"),0);
        assertEquals(  voter.getvoting(link,voting).get("apc"),2);




    }



    @Test
    public void testVoterLinkNull(){
        Voting voting = new Voting();
        voting.addAdmin("usman","1234");
        voting.addAdmin("elety","piqo");
        voting.addAdmin("garaz","0305");
        voting.addVoter("elety","piqo");
        voting.addVoter("garaz","0305");
        Admin person=  voting.findAdmin("usman","1234");

        person.setTitle("voting for president");
        List <String> parties= new ArrayList<>();
        parties.add("apc");
        parties.add("pdp");
        parties.add("nop");
        person.createPool(parties);
        Voter voter = voting.findVoter("elety","piqo");
        Voter voter1 = voting.findVoter("garaz","0305");
        String link = person.getLink();
        voter1.vote("apc",link,voting,person);
        voter.vote("apc",link,voting,person);

        assertNull(  voter.getvoting("",voting));
        assertNull(  voter.getvoting("",voting));




    }



    @Test
    public void testVoterError(){
        Voting voting = new Voting();
        voting.addAdmin("usman","1234");
        voting.addAdmin("elety","piqo");
        voting.addAdmin("garaz","0305");
        voting.addVoter("elety","piqo");
        voting.addVoter("garaz","0305");
        Admin person=  voting.findAdmin("usman","1234");

        person.setTitle("voting for president");
        List <String> parties= new ArrayList<>();
        parties.add("apc");
        parties.add("pdp");
        parties.add("nop");
        person.createPool(parties);
        Voter voter = voting.findVoter("elety","piqo");

        String link = person.getLink();
        voter.vote("apc",link,voting,person);


        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            voter.checkIfVoterhasVotedAlready(person);
        });

        assertEquals("You have voted already", exception.getMessage());




    }


}