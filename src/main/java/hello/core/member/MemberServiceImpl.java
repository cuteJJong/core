package hello.core.member;

public class MemberServiceImpl implements MemberService {

	//할당하는 부분이 구현체를 의존 DIP 위반
	private final MemberRepository memberRepository = new MemoryMemberRepository();


	@Override
	public void join(Member member) {
		memberRepository.save(member);
	}

	@Override
	public Member findMember(Long memberId) {
		return memberRepository.findById(memberId);
	}

}
