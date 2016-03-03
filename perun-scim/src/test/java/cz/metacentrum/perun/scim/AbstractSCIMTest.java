package cz.metacentrum.perun.scim;

import cz.metacentrum.perun.core.api.ExtSourcesManager;
import cz.metacentrum.perun.core.api.Group;
import cz.metacentrum.perun.core.api.Member;
import cz.metacentrum.perun.core.api.PerunPrincipal;
import cz.metacentrum.perun.core.api.PerunSession;
import cz.metacentrum.perun.core.api.User;
import cz.metacentrum.perun.core.api.Vo;
import cz.metacentrum.perun.core.api.exceptions.*;
import cz.metacentrum.perun.core.bl.PerunBl;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:perun-scim.xml"})
@TransactionConfiguration(defaultRollback = true, transactionManager = "perunTransactionManager")
@Transactional
public abstract class AbstractSCIMTest {

    @Autowired
    private PerunBl perun;
    private User user1;

    public PerunSession session;

    public static Vo vo1;
    public static Vo vo2;
    public static Group group1Vo1;
    public static Group group2Vo2;
    public static Member member1;
    public static Member member2;
    public static User user2;
    public static User user3;

    @Before
    public void setUpSession() throws Exception {
        session = perun.getPerunSession(new PerunPrincipal("perunTests", ExtSourcesManager.EXTSOURCE_NAME_INTERNAL, ExtSourcesManager.EXTSOURCE_INTERNAL));
        user1 = createTestUser();
        session.getPerunPrincipal().setUser(user1);
    }

    private User createTestUser() throws InternalErrorException {
        User user = new User();
        user.setFirstName("James");
        user.setMiddleName("");
        user.setLastName("Bond");
        user.setTitleBefore("");
        user.setTitleAfter("");
        return perun.getUsersManagerBl().createUser(session, user);
    }

    public final void createVos() throws Exception {
        vo1 = perun.getVosManagerBl().createVo(session, new Vo(0, "vo1", "vo1"));
        vo2 = perun.getVosManagerBl().createVo(session, new Vo(0, "vo1", "vo1"));
    }

    public final void createGroups() throws Exception {
        group1Vo1 = perun.getGroupsManagerBl().createGroup(session, vo1, new Group("group1", "group1 in vo1"));
        group2Vo2 = perun.getGroupsManagerBl().createGroup(session, vo2, new Group("group2", "group2 in vo2"));
    }

    public final void createUsers() throws Exception {
        user2 = new User(2, "user2-firstName", "user2-lastName", null, null, null);
        perun.getUsersManagerBl().createUser(session, user2);

        user3 = new User(3, "user3-firstName", "user3-lastName", null, null, null);
        perun.getUsersManagerBl().createUser(session, user3);
    }

    public final void createMembers() throws Exception {
        member1 = perun.getMembersManagerBl().createMember(session, vo1, user1);
        perun.getGroupsManagerBl().addMember(session, group1Vo1, member1);
        member2 = perun.getMembersManagerBl().createMember(session, vo2, user2);
        perun.getGroupsManagerBl().addMember(session, group2Vo2, member2);
    }
}
