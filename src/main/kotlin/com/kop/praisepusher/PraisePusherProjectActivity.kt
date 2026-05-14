package com.kop.praisepusher

import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.ProjectActivity
import com.intellij.openapi.vcs.changes.ChangeListListener
import git4idea.push.GitPushListener

class PraisePusherProjectActivity : ProjectActivity {
    override suspend fun execute(project: Project) {
        val connection = project.messageBus.connect(project)
        connection.subscribe(GitPushListener.TOPIC, GitPushPraiseListener())
        connection.subscribe(ChangeListListener.TOPIC, GitAddPraiseChangeListListener(project))
    }
}
