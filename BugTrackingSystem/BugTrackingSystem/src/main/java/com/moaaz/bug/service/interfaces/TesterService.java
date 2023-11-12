package com.moaaz.bug.service.interfaces;

import com.moaaz.bug.model.Tester;

import java.util.List;

public interface TesterService {

    public Tester addTester(Tester tester);

    public Tester updateTester(Tester tester);

    public void deleteTesterById(int id);

    public Tester getTesterByIdOrElseThrowException(int testerId);

    public List<Tester> getAllTesters();

    public void addBonusForTester(int testerId);
}
