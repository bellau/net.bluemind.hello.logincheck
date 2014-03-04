package net.bluemind.hello.logincheck;

import net.bluemind.core.api.AccessToken;
import net.bluemind.core.api.Entity;
import net.bluemind.core.api.fault.ServerFault;
import net.bluemind.core.api.user.User;
import net.bluemind.core.sanity.ISanityChecker;

public class HelloAtStartChecker implements ISanityChecker {

	@Override
	public void preCreateCheck(AccessToken at, Entity e) throws ServerFault {
		ensureLoginStartsWithHello(e);
	}

	@Override
	public void preUpdateCheck(AccessToken at, Entity prev, Entity e)
			throws ServerFault {
		ensureLoginStartsWithHello(e);
	}

	private void ensureLoginStartsWithHello(Entity e) throws ServerFault {
		User u = (User) e;
		if (!u.getLogin().startsWith("hello")) {
			throw new ServerFault("Login must start with 'hello' !");
		}
	}

	@Override
	public void preDeleteCheck(AccessToken at, Entity e) throws ServerFault {
	}

}
