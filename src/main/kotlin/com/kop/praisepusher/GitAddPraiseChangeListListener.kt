package com.kop.praisepusher

import com.intellij.openapi.project.Project
import com.intellij.openapi.vcs.ProjectLevelVcsManager
import com.intellij.openapi.vcs.changes.Change
import com.intellij.openapi.vcs.changes.ChangeList
import com.intellij.openapi.vcs.changes.ChangeListAdapter

class GitAddPraiseChangeListListener(
    private val project: Project
) : ChangeListAdapter() {

    override fun changesAdded(changes: Collection<Change>, toList: ChangeList) {
        val vcsManager = ProjectLevelVcsManager.getInstance(project)
        if (!vcsManager.checkVcsIsActive(GIT_VCS_NAME)) return

        val addedFileNames = changes.asSequence()
            .filter { it.type == Change.Type.NEW }
            .mapNotNull { it.afterRevision?.file }
            .filter { filePath -> vcsManager.getVcsFor(filePath)?.name == GIT_VCS_NAME }
            .map { it.name }
            .distinct()
            .toList()

        if (addedFileNames.isEmpty()) return

        PraiseNotifications.notify(project, PraiseNotifications.addedFilesPraise(addedFileNames))
    }

    companion object {
        private const val GIT_VCS_NAME = "Git"
    }
}
