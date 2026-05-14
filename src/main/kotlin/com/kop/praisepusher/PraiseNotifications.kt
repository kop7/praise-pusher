package com.kop.praisepusher

import com.intellij.notification.NotificationGroupManager
import com.intellij.notification.NotificationType
import com.intellij.openapi.project.Project

object PraiseNotifications {
    private const val NOTIFICATION_GROUP_ID = "Praise Pusher"

    private val PUSH_MESSAGES = listOf(
        "Great job, your push went through!",
        "Code shipped. Nice work!",
        "Another clean push. You are on fire.",
        "Git accepted it. I am proud of you.",
        "Push successful. That was smooth."
    )

    private val COMMIT_MESSAGES = listOf(
        "Commit saved. Great momentum.",
        "Nice commit. Progress locked in.",
        "Clean commit. Keep it up.",
        "Another solid commit. Well done.",
        "Commit successful. Good work."
    )

    fun randomPushPraise(): String = PUSH_MESSAGES.random()

    fun randomCommitPraise(): String = COMMIT_MESSAGES.random()

    fun addedFilesPraise(fileNames: List<String>): String {
        if (fileNames.size == 1) {
            return "Added '${fileNames.first()}' to Git. Nice."
        }

        return "Added ${fileNames.size} new files to Git. Great progress."
    }

    fun notify(project: Project, message: String) {
        NotificationGroupManager.getInstance()
            .getNotificationGroup(NOTIFICATION_GROUP_ID)
            .createNotification(message, NotificationType.INFORMATION)
            .notify(project)
    }
}
