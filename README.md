# Praise Pusher

Praise Pusher is a lightweight PhpStorm plugin that shows friendly motivational notifications after key Git actions.

## Features

- Shows a random message after a successful Git push
- Shows a message when a new file is added to Git
- Shows a message after a successful commit

## Plugin Metadata

- **Plugin ID:** `com.kop.praisepusher`
- **Name:** `Praise Pusher`
- **Target IDE:** PhpStorm `2025.3`
- **Version:** `0.1.0`

> Keep the plugin ID unchanged after publishing. It is the permanent identity on Marketplace.

## Requirements

- JDK 21
- Gradle wrapper (included)

## Run Locally

```bash
./gradlew runIde
```

This starts a sandbox PhpStorm instance with the plugin loaded.

## Build Plugin ZIP

```bash
./gradlew buildPlugin
```

Output file:

```text
build/distributions/praise-pusher-0.1.0.zip
```

## Install ZIP Manually in PhpStorm

1. Open **Settings / Preferences**
2. Go to **Plugins**
3. Click the gear icon
4. Choose **Install Plugin from Disk...**
5. Select:
   `build/distributions/praise-pusher-0.1.0.zip`

## Publish on JetBrains Marketplace (Manual)

1. Build the ZIP with:
   ```bash
   ./gradlew buildPlugin
   ```
2. Open JetBrains Marketplace and sign in
3. Add plugin and upload:
   `build/distributions/praise-pusher-0.1.0.zip`
4. Fill release metadata (description, change notes, compatibility)

## Suggested Marketplace Text

### Short Description

Get friendly motivational messages after successful Git add, commit, and push actions.

### Full Description

Praise Pusher shows lightweight motivational notifications inside PhpStorm after key Git actions.

It currently supports:
- `git add` (when a new file is added to Git)
- successful commit
- successful push

The plugin is intentionally simple and unobtrusive, providing a small positive feedback loop while shipping code.

### Change Notes (`0.1.0`)

Initial release:
- Shows motivational notifications after successful Git push.
- Shows motivational notifications when new files are added to Git.
- Shows motivational notifications after successful commit.
- Supports PhpStorm projects using Git.

## License

Apache License 2.0. See [LICENSE](LICENSE).
