package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Kristopher", Developer.getName());
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void getGitHubId_returns_correct_githubId () {
        assertEquals("schoolKris08", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team t = Developer.getTeam();
        assertEquals("s26-15", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_memebers() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Katelyn"), "Team should contian Katelyn");
        assertTrue(t.getMembers().contains("Mikaela"), "Team should contian Mikaela");
        assertTrue(t.getMembers().contains("Joy"), "Team should contian Joy");
        assertTrue(t.getMembers().contains("Leo"), "Team should contian Leo");
        assertTrue(t.getMembers().contains("Xuanbo"), "Team should contian Xuanbo");
        assertTrue(t.getMembers().contains("Kristopher"), "Team should contian Kristopher");
    }
}
