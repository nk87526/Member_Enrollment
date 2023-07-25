package com.memberenrollment.controller;



        //import com.memberenrollment.Member;
        import org.example.com.memberenrollment.Member;
        //import org.example.com.memberenrollment.MemberRepository;
        import org.example.com.memberenrollment.controller.MemberController;
        import org.example.com.memberenrollment.repository.MemberRepository;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;
        import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.mockito.MockitoAnnotations;
        import org.springframework.http.MediaType;
        import org.springframework.test.web.servlet.MockMvc;
        import org.springframework.test.web.servlet.setup.MockMvcBuilders;
        import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
        import com.fasterxml.jackson.databind.ObjectMapper;



        import static org.mockito.Mockito.*;

public class MemberControllerTest {

    private MockMvc mockMvc;

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberController memberController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(memberController).build();
    }

    // Add test cases here
    @Test
    public void testCreateMember() throws Exception {
        // Given
        Member memberToCreate = new Member();
        memberToCreate.setFirstName("John");
        memberToCreate.setLastName("Doe");
        memberToCreate.setEmail("john.doe@example.com");
        memberToCreate.setBirthdate("1990-01-01");

        // When
        when(memberRepository.save(any(Member.class))).thenReturn(memberToCreate);

        // Then
        mockMvc.perform(post("/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(memberToCreate)))
                .andExpect(status().isOk())
                .andExpect(content().string("Member enrollment successful!"));

        // Verify that the member was saved in the repository
        verify(memberRepository, times(1)).save(any(Member.class));
    }

    // Utility method to convert objects to JSON string
    private String asJsonString(Object obj) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
