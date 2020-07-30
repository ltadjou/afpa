package session;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import entities.Administrateur;

@Component("sessionAdmin")
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS )
public class SessionAdmin {
	
	private Administrateur lastLogIn;

	public Administrateur getLastLogIn() {
		return lastLogIn;
	}

	public void setLastLogIn(Administrateur lastLogIn) {
		this.lastLogIn = lastLogIn;
	}
	
}
