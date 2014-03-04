package net.bluemind.hello.logincheck;

import net.bluemind.core.api.Entity;
import net.bluemind.core.api.user.User;
import net.bluemind.core.sanity.ISanityChecker;
import net.bluemind.core.sanity.ISanityCheckerFactory;

public class HelloCheckerFactory implements ISanityCheckerFactory {

	@Override
	public ISanityChecker create() {
		return new HelloAtStartChecker();
	}

	@Override
	public boolean supports(Entity e) {
		return e instanceof User;
	}

}
