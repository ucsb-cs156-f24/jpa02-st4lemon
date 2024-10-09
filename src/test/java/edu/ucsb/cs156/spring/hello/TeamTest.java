package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("f24-13");  
        team.addMember("David");  
        team.addMember("Emily");  
        team.addMember("Steven");  
        team.addMember("Andy");  
        team.addMember("Anvitha");  
        team.addMember("Shivani");  
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("f24-13"));
    }

    @Test
    public void hashCode_returns_correct_hashCode() {
        assertEquals(team.name.hashCode() | team.members.hashCode(), team.hashCode());
    }

    @Test
    public void toString_returns_correct_toString() {
        assertEquals("Team(name=" + team.name + ", members=" + team.members + ")", team.toString());
    }

    @Test
    public void equals_self() {
        assertTrue(team.equals(team), "Team should equal itself");
    }
    
    @Test
    public void not_equals_other_object() {
        assertFalse(team.equals(new ArrayList<Integer>()), "Team should not equal an ArrayList");
    }
   
    @Test
    public void equals_equivalent_team() {
        Team temp = new Team("f24-13");
        temp.addMember("David");  
        temp.addMember("Emily");  
        temp.addMember("Steven");  
        temp.addMember("Andy");  
        temp.addMember("Anvitha");  
        temp.addMember("Shivani");  
        assertTrue(team.equals(temp), "Team should equal equivalent team");
    }

    @Test
    public void not_equals_different_name() {
        Team temp = new Team("s24-14");
        temp.addMember("David");  
        temp.addMember("Emily");  
        temp.addMember("Steven");  
        temp.addMember("Andy");  
        temp.addMember("Anvitha");  
        temp.addMember("Shivani");  
        assertFalse(team.equals(temp), "Team should not equal different name");
    }

    @Test
    public void not_equals_different_members() {
        Team temp = new Team("f24-13");
        temp.addMember("Phillip");
        temp.addMember("Conrad");
        temp.addMember("Xifeng");
        temp.addMember("Lingqi");
        assertFalse(team.equals(temp), "Team should not equal different members");
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
