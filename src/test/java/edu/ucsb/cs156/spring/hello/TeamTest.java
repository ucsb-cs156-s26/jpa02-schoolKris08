package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }
   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    //this will check if when objs are checked to eqaul to each other, if true, should result true
    @Test
    public void testEquals_sameObjectType() {
        assertTrue(team.equals(team));
    }

    //in class team java, an obj not matching should return false
    @Test 
    public void testDiff_Object_Type() {
        assertFalse(team.equals(null));
    }

    //tests for objects contents
    @Test 
    public void TestEquals_sameNameAndMember() {
        Team sameObj = new Team("test-team");
        Team differentName = new Team("other-team");
        Team sameNameDifferentMembers = new Team ("test-team");
        sameNameDifferentMembers.getMembers().add("Gaucho");
        assertTrue(team.equals(sameObj));
        assertFalse(team.equals(sameNameDifferentMembers));
        differentName.getMembers().add("Gaucho");
        assertFalse(team.equals(differentName));
    }

    @Test
    public void hashCode_contentCheck_sameHash() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");

        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");

        //objs should be eqaul
        assertEquals(true, t1.equals(t2));

        //conents of object/hashCodes should match as well
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void hashCode_specificValue() {
        Team t = new Team("test-team");
        int result = t.hashCode();
        // int expectedResult = 0;
        // was -1226298695
        assertEquals(-1226298695, result);
    }
}
