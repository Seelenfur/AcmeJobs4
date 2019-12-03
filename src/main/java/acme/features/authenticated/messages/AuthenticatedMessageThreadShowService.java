
package acme.features.authenticated.messages;

import org.springframework.beans.factory.annotation.Autowired;

import acme.entities.message.MessageThread;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

public class AuthenticatedMessageThreadShowService implements AbstractShowService<Authenticated, MessageThread> {

	@Autowired
	AuthenticatedMessageThreadRepository repository;


	@Override
	public boolean authorise(final Request<MessageThread> request) {
		assert request != null;
		boolean result;
		int messageThreadId;
		Integer messagesOfUserInThread;
		Principal principal = request.getPrincipal();

		messageThreadId = request.getModel().getInteger("id");
		messagesOfUserInThread = this.repository.findNumberOfMessagesOfUserInThread(messageThreadId, principal.getActiveRoleId());
		result = messagesOfUserInThread > 0;

		return result;
	}

	@Override
	public void unbind(final Request<MessageThread> request, final MessageThread entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "moment", "id");
	}

	@Override
	public MessageThread findOne(final Request<MessageThread> request) {
		assert request != null;

		MessageThread result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneMessageThreadById(id);

		return result;
	}

}