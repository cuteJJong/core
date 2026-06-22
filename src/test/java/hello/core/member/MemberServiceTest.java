package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

	MemberService memberService;

	// 테스트를 실행 전에 메서드를 무조건 실행하게 해주는 어노테이션
	@BeforeEach
	public void beforeEach() {
		AppConfig config = new AppConfig();
		memberService = config.memberService();
	}

	@Test
	void join() {
		//given
		Member member = new Member(1L, "memberA", Grade.VIP);

		//when
		memberService.join(member);
		Member findMember = memberService.findMember(1L);

		//then
		Assertions.assertThat(member).isEqualTo(findMember);
	}

}
