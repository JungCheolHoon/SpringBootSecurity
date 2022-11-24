package kr.kwangan2.springbootsecurity.config;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import kr.kwangan2.springbootsecurity.domain.Member;

public class SecurityUser extends User{
	
	private static final long serialVersionUID = 121452452463L;

	public SecurityUser(Member member) {
		super(member.getId(), member.getPassword(), 
				AuthorityUtils.createAuthorityList(member.getRole().toString()));
	}
	
}
