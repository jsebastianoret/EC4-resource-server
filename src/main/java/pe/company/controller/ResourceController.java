package pe.company.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.company.dto.MessageDto;

@RestController
@RequestMapping("/resource")
public class ResourceController {
	
	@GetMapping("/user")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<MessageDto> user(Authentication authentication){
		
		return ResponseEntity.ok(new MessageDto("Hellos user "+authentication.getName()));
	}
	
	
	@GetMapping("/admin")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<MessageDto> admin(Authentication authentication){
		
		return ResponseEntity.ok(new MessageDto("Hello admin "+authentication.getName()));
	}
	
	
	@GetMapping("/sebas")
	@PreAuthorize("hasAuthority('ROLE_SEBAS')")
	public ResponseEntity<MessageDto> sebas(Authentication authentication){
		
		return ResponseEntity.ok(new MessageDto("Hello role sebas " + authentication.getName()));
	}
	
	
	
	

}
