<div align="center">

<img src="https://capsule-render.vercel.app/api?type=venom&height=280&color=0:020617,25:0F172A,55:0369A1,80:2563EB,100:67E8F9&text=ORYNLAUNCHER%20PREMIUM&fontColor=FFFFFF&fontSize=42&fontAlignY=45&desc=MINECRAFT%20JAVA%20EDITION%20%E2%80%A2%20ANDROID&descSize=15&descAlignY=65&animation=twinkling&stroke=67E8F9&strokeWidth=1" width="100%" alt="Animated OrynLauncher Premium 3D-inspired banner" />

<br/>

<a href="https://github.com/Orynlauncher-Official/OrynLauncher-Premium"><img src="https://readme-typing-svg.demolab.com?font=Orbitron&weight=600&size=19&duration=2800&pause=900&color=67E8F9&center=true&vCenter=true&width=700&lines=YOUR+MINECRAFT.+YOUR+ANDROID.;A+NEW+LAUNCHER+EXPERIENCE.;BUILT+ON+OPEN-SOURCE+FOUNDATIONS." alt="Animated OrynLauncher tagline" /></a>

<br/>

<a href="https://github.com/Orynlauncher-Official/OrynLauncher-Premium/actions"><img src="https://img.shields.io/github/actions/workflow/status/Orynlauncher-Official/OrynLauncher-Premium/import-and-build.yml?branch=main&style=for-the-badge&logo=githubactions&logoColor=white&label=CI%20BUILD" alt="Build status"></a>
<a href="https://github.com/Orynlauncher-Official/OrynLauncher-Premium/commits/main"><img src="https://img.shields.io/github/last-commit/Orynlauncher-Official/OrynLauncher-Premium/main?style=for-the-badge&logo=git&logoColor=white&label=LATEST%20UPDATE" alt="Last update"></a>
<img src="https://img.shields.io/badge/ANDROID-APPLICATION-3DDC84?style=for-the-badge&logo=android&logoColor=white" alt="Android application">
<img src="https://img.shields.io/badge/MINECRAFT-JAVA%20EDITION-38BDF8?style=for-the-badge&logo=minecraft&logoColor=white" alt="Minecraft Java Edition">

<br/><br/>

<a href="https://github.com/Orynlauncher-Official/OrynLauncher-Premium/actions"><img src="https://img.shields.io/badge/WORKFLOW-ACTIONS-111827?style=flat-square&logo=githubactions&logoColor=67E8F9" alt="Actions"></a>
<a href="https://github.com/Orynlauncher-Official/OrynLauncher-Premium/issues"><img src="https://img.shields.io/badge/BUGS-REPORT-111827?style=flat-square&logo=github&logoColor=67E8F9" alt="Report issues"></a>
<a href="https://github.com/MojoLauncher/MojoLauncher"><img src="https://img.shields.io/badge/UPSTREAM-MOJO-111827?style=flat-square&logo=github&logoColor=67E8F9" alt="MojoLauncher upstream"></a>

</div>

---

<div align="center">

## ✦ A Different Way to Play

**OrynLauncher Premium** is an Android launcher project focused on bringing the Minecraft: Java Edition experience to supported mobile devices.

A distinctive Oryn identity, an Android-first direction, and open-source foundations — developed one improvement at a time.

</div>

> **Development status:** Work in progress. Builds, compatibility, and features can change. The badges and visuals do not imply that the latest APK build has succeeded.

## ◈ Project at a Glance

<table>
<tr>
<td width="50%" valign="top">

### 🎮 Minecraft on Android
Launcher project designed around running Minecraft: Java Edition on compatible Android devices, using the underlying upstream launcher and runtime components.

</td>
<td width="50%" valign="top">

### ⚙️ Open-Source Foundations
Built from existing open-source launcher work, with upstream components, submodules, and their required notices retained.

</td>
</tr>
<tr>
<td width="50%" valign="top">

### 💠 Oryn Identity
The project uses the OrynLauncher Premium name and package identity while the launcher continues to be developed.

</td>
<td width="50%" valign="top">

### 🧪 Build Transparency
GitHub Actions is used to import source and attempt a debug build. Check the actual workflow result before treating a build as ready.

</td>
</tr>
</table>

## ⬡ Download / Test Builds

No release or working APK is promised by this README. To check for a build:

1. Open **[GitHub Actions](https://github.com/Orynlauncher-Official/OrynLauncher-Premium/actions)**.
2. Select the latest workflow run.
3. Confirm that its conclusion is **Success**.
4. If an APK artifact is available, download it from the run's **Artifacts** section.

Development APKs may contain bugs and may not work on every device. Only install builds from sources you trust.

<div align="center">
<a href="https://github.com/Orynlauncher-Official/OrynLauncher-Premium/actions"><img src="https://img.shields.io/badge/OPEN-BUILD%20PIPELINE-0284C7?style=for-the-badge&logo=githubactions&logoColor=white" alt="Open build pipeline"></a>
<a href="https://github.com/Orynlauncher-Official/OrynLauncher-Premium/releases"><img src="https://img.shields.io/badge/VIEW-RELEASES-0F172A?style=for-the-badge&logo=github&logoColor=white" alt="View releases"></a>
</div>

## 🛠️ Build from Source

### Requirements

- Git
- Android SDK
- Java and Android NDK versions compatible with the current build workflow
- Network access for dependencies and upstream submodules

### Build command

The Android application module is named **`app_orynlauncher`**.

```bash
gradle :app_orynlauncher:assembleFullDebug --stacktrace
```

Before building locally, review the [CI workflow](https://github.com/Orynlauncher-Official/OrynLauncher-Premium/blob/main/.github/workflows/import-and-build.yml) and the Gradle configuration. This command describes the configured build task; it is not a guarantee that the current branch builds successfully.

## 🧭 Project Links

| Resource | Link |
| --- | --- |
| Source repository | [OrynLauncher Premium](https://github.com/Orynlauncher-Official/OrynLauncher-Premium) |
| Build workflow | [GitHub Actions](https://github.com/Orynlauncher-Official/OrynLauncher-Premium/actions) |
| Releases and artifacts | [Releases](https://github.com/Orynlauncher-Official/OrynLauncher-Premium/releases) |
| Report a bug | [Open an issue](https://github.com/Orynlauncher-Official/OrynLauncher-Premium/issues/new) |
| Upstream project | [MojoLauncher](https://github.com/MojoLauncher/MojoLauncher) |
| Related upstream project | [PojavLauncher](https://github.com/PojavLauncherTeam/PojavLauncher) |

## 🐛 Reporting Problems

Before opening an issue, search existing reports. Please include:

- Device model and Android version
- The exact steps to reproduce the issue
- Expected behaviour and actual behaviour
- Relevant error messages or logs

**Never post passwords, Microsoft account tokens, session cookies, signing keys, or other private credentials.**

## 🤝 Contributing

Contributions, testing, and well-documented bug reports are welcome. Keep changes focused, explain their purpose, and provide verification steps. For major changes, open an issue first to discuss the approach.

## 📜 Credits & Licensing

OrynLauncher Premium is an independent project derived from or incorporating components of existing open-source launcher projects. Thanks to the original maintainers and contributors of [MojoLauncher](https://github.com/MojoLauncher/MojoLauncher), [PojavLauncher](https://github.com/PojavLauncherTeam/PojavLauncher), and other included projects.

Upstream source, native components, and third-party dependencies retain their own copyright notices and license obligations. The upstream launcher includes LGPL-licensed code; review the repository's `LICENSE`, bundled notices, and relevant component licenses before modifying or redistributing the project. OrynLauncher branding does not imply ownership of upstream code or official affiliation with upstream projects.

---

<div align="center">

<img src="https://capsule-render.vercel.app/api?type=waving&section=footer&height=130&color=0:67E8F9,45:1D4ED8,100:020617" width="100%" alt="Animated OrynLauncher footer" />

<sub><strong>ORYNLAUNCHER PREMIUM</strong> · Made for the Minecraft-on-Android community</sub>

<br/>

<sub>Open source roots. Independent identity. Ongoing development.</sub>

</div>
