package com.app.clean.base;

import com.app.clean.domain.interactor.UseCase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CPBridge {

    private List<UseCase> mCaseList = new ArrayList<>();

    public void addCase(UseCase useCase) {
        if (!mCaseList.contains(useCase)) {
            mCaseList.add(useCase);
        }
    }

    public void removeCase() {
        Iterator<UseCase> iterator = mCaseList.iterator();
        while (iterator.hasNext()) {
            UseCase useCase = iterator.next();
            useCase.dispose();
            mCaseList.remove(useCase);
        }
    }

}
