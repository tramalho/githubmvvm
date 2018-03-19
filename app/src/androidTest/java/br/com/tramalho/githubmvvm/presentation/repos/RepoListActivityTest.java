package br.com.tramalho.githubmvvm.presentation.repos;


import android.app.Application;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.tramalho.githubmvvm.testutilities.CustomMockApplication;
import br.com.tramalho.githubmvvm.testutilities.EspressoUtils;

import static junit.framework.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class RepoListActivityTest {

    @Rule
    public ActivityTestRule<RepoListActivity> mActivityTestRule = new ActivityTestRule<>(RepoListActivity.class);

    @Test
    public void testMockApplication() {
        Application application = mActivityTestRule.getActivity().getApplication();
        assertEquals(CustomMockApplication.class.getSimpleName(), application.getClass().getSimpleName());
    }

    @Test
    public void TestRepoListActivity() throws InterruptedException {
        Thread.sleep(1000);
        EspressoUtils.hasText("ReactiveX/RxJava", "ReactiveX", "5534", "31597");
    }
}
