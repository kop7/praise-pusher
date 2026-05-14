package com.kop.praisepusher

import com.intellij.openapi.vcs.CheckinProjectPanel
import com.intellij.openapi.vcs.ProjectLevelVcsManager
import com.intellij.openapi.vcs.changes.CommitContext
import com.intellij.openapi.vcs.checkin.CheckinHandler
import com.intellij.openapi.vcs.checkin.CheckinHandlerFactory

class GitCommitPraiseHandlerFactory : CheckinHandlerFactory() {
    override fun createHandler(panel: CheckinProjectPanel, commitContext: CommitContext): CheckinHandler {
        return object : CheckinHandler() {
            override fun checkinSuccessful() {
                val project = panel.project
                if (!ProjectLevelVcsManager.getInstance(project).checkVcsIsActive(GIT_VCS_NAME)) return

                PraiseNotifications.notify(project, PraiseNotifications.randomCommitPraise())
            }
        }
    }

    companion object {
        private const val GIT_VCS_NAME = "Git"
    }
}
