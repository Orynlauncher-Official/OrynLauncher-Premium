<div align="center">

<img src="https://capsule-render.vercel.app/api?type=waving&height=210&color=0:070B14,45:102A43,100:38BDF8&text=OrynLauncher%20Premium&fontColor=FFFFFF&fontSize=42&fontAlignY=38&desc=Minecraft%20Java%20Edition%20Launcher%20for%20Android&descAlignY=60&descSize=15&animation=fadeIn" width="100%" alt="OrynLauncher Premium banner" />

<p>
  <strong>A community-driven Android launcher project for Minecraft: Java Edition.</strong>
</p>

<p>
  <a href="https://github.com/Orynlauncher-Official/OrynLauncher-Premium/actions"><img src="https://img.shields.io/github/actions/workflow/status/Orynlauncher-Official/OrynLauncher-Premium/import-and-build.yml?branch=main&style=for-the-badge&label=Build" alt="Build status"></a>
  <a href="https://github.com/Orynlauncher-Official/OrynLauncher-Premium/commits/main"><img src="https://img.shields.io/github/last-commit/Orynlauncher-Official/OrynLauncher-Premium/main?style=for-the-badge&label=Last%20update" alt="Last update"></a>
  <img src="https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white" alt="Android">
  <img src="https://img.shields.io/badge/Game-Minecraft%20Java-45A1FF?style=for-the-badge&logo=minecraft&logoColor=white" alt="Minecraft Java Edition">
</p>

<p>
  <a href="https://github.com/Orynlauncher-Official/OrynLauncher-Premium/actions">Builds</a> ·
  <a href="https://github.com/Orynlauncher-Official/OrynLauncher-Premium/issues">Issues</a> ·
  <a href="https://github.com/Orynlauncher-Official/OrynLauncher-Premium">Source code</a>
</p>

</div>

---

## Overview

**OrynLauncher Premium** is an Android launcher project intended to bring the Minecraft: Java Edition experience to supported mobile devices. The project builds on the open-source work of MojoLauncher and PojavLauncher, with OrynLauncher branding and ongoing independent development.

This repository is a work in progress. Compatibility, features, and build availability may change as development continues.

## Project goals

- **Android-focused experience** — make the launcher practical to use on supported Android devices.
- **Minecraft Java compatibility** — retain the upstream launcher foundations and relevant runtime components.
- **Maintainable source** — keep build configuration, native components, and required submodules together.
- **Independent identity** — develop and present the project under the OrynLauncher Premium name.
- **Transparent development** — use repository issues and CI runs to track problems and verify changes.

## Download and builds

No release is implied by this README. To check whether a build is currently available:

1. Visit **[GitHub Actions](https://github.com/Orynlauncher-Official/OrynLauncher-Premium/actions)**.
2. Open a completed workflow run and confirm that it succeeded.
3. If an APK artifact is published by that run, download it from the run's **Artifacts** section.

Development builds may contain bugs and are not guaranteed to work on every device. Install APKs only from sources you trust.

## Build from source

### Requirements

- Git
- Android SDK and a compatible Android build environment
- Java version and Android NDK version specified by the current workflow
- Network access to retrieve upstream submodules and build dependencies

### Build task

The Android application module is named `app_orynaluncher`. The CI workflow currently attempts to build the full debug variant with:

```bash
gradle :app_orynaluncher:assembleFullDebug
```

For a reproducible build, review the current [build workflow](https://github.com/Orynlauncher-Official/OrynLauncher-Premium/blob/main/.github/workflows/import-and-build.yml) and the Gradle configuration before building locally. A successful build must be confirmed in the Actions run; the command shown here is not a claim that the latest source currently builds.

## Reporting an issue

Before opening an issue, check whether it has already been reported.

When submitting a bug report, include:
- Device model and Android version
- Steps to reproduce the problem
- Expected and actual behaviour
- Relevant error messages or logs

**Never include passwords, Microsoft account tokens, session cookies, signing keys, or other private credentials in issues or logs.**

[Open an issue](https://github.com/Orynlauncher-Official/OrynLauncher-Premium/issues/new)

## Contributing

Contributions, testing, and clear bug reports are welcome. Please keep changes focused, describe the reason for the change, and include steps to verify it. For larger changes, open an issue first to discuss the proposed approach.

## Credits and licensing

OrynLauncher Premium is an independent project derived from or incorporating components of existing open-source launcher projects. We are grateful to the original maintainers and contributors.

- [MojoLauncher](https://github.com/MojoLauncher/MojoLauncher)
- [PojavLauncher](https://github.com/PojavLauncherTeam/PojavLauncher)

Upstream code and third-party dependencies remain subject to their own licenses and copyright notices. The upstream launcher source includes LGPL-licensed code; review the repository's `LICENSE`, bundled notices, and relevant component licenses before modifying or redistributing the project. OrynLauncher branding does not imply ownership of upstream code or affiliation with the upstream projects.

---

<div align="center">

<img src="https://capsule-render.vercel.app/api?type=rect&height=3&color=0:38BDF8,50:1D4ED8,100:070B14" width="100%" alt="" />

<sub>OrynLauncher Premium · Independent community project · Built on open-source foundations</sub>

</div>
