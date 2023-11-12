package com.moaaz.bug.service.implemenation;

import com.moaaz.bug.model.Developer;
import com.moaaz.bug.model.Message;
import com.moaaz.bug.model.Tester;
import com.moaaz.bug.repository.MessageRepository;
import com.moaaz.bug.service.interfaces.DeveloperService;
import com.moaaz.bug.service.interfaces.TesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService implements com.moaaz.bug.service.interfaces.MessageService {

    @Autowired
    private MessageRepository messageRepo;
    @Autowired
    private TesterService testerService;
    @Autowired
    private DeveloperService developerService;

    @Override
    public void sendMessageForTester(int testerId, int developerId) {
//        Tester tester = testerService.getTesterByIdOrElseThrowException(testerId);
//        Message message= new Message(-1 , "Ther")
//        messageRepo.save(message);
    }

    @Override
    public void sendMessageForDeveloper(int testerId, int developerId) {
        Developer developer = developerService.getDeveloperByIdOrElseThrowException(developerId);
        Tester tester = testerService.getTesterByIdOrElseThrowException(testerId);
        developer.addMessageToDeveloperMessages(
                new Message(-1, "There Are A new Bug For You...", tester.getName()));
        developerService.updateDeveloper(developer);
    }

}
