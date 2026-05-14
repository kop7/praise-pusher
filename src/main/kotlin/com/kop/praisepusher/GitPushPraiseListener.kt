package com.kop.praisepusher

import git4idea.push.GitPushListener
import git4idea.push.GitPushRepoResult
import git4idea.repo.GitRepository

class GitPushPraiseListener : GitPushListener {
    override fun onCompleted(repository: GitRepository, pushResult: GitPushRepoResult) {
        if (!isSuccessfulPush(pushResult)) return

        PraiseNotifications.notify(repository.project, PraiseNotifications.randomPushPraise())
    }

    private fun isSuccessfulPush(pushResult: GitPushRepoResult): Boolean {
        return when (pushResult.type) {
            GitPushRepoResult.Type.SUCCESS,
            GitPushRepoResult.Type.NEW_BRANCH,
            GitPushRepoResult.Type.FORCED -> true
            else -> false
        }
    }

}
