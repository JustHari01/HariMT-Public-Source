<div align="center">

# HariMultiThread (HE: HariEntity) — Minecraft 1.20.1 ⚙️

[![Discord](https://img.shields.io/badge/Discord-Join-5865F2?style=for-the-badge&logo=discord&logoColor=white)](https://discord.com/invite/scvCQ2qKS3)
[![GitHub Issues](https://img.shields.io/github/issues/JustHari01/HariMT-Public-Source?style=for-the-badge)](https://github.com/JustHari01/HariMT-Public-Source/issues)
</div>



This repository contains the source for HariMultiThread, listed as “HE: HariEntity” on Modrinth and CurseForge. It is a community fork of Async for Minecraft 1.20.1 and includes Forge and Fabric build modules. Modrinth currently lists the Forge build; CurseForge has both Forge and Fabric files. This project is maintained independently from the upstream authors.


## Important❗
**Async** is currently in alpha testing and is experimental. Its use may lead to incorrect entity behavior and crashes. It may be even more unstable on 1.20.1!



### 💡 Key Benefits:
- ⚡ **Improved TPS**: Maintains stable tick times even with a large number of entities.
- 🚀 **Multithreading**: Utilizes multiple CPU cores for parallel entity processing.
- 🎲 **Async Random Ticks** (Experimental): Processes random ticks asynchronously for better performance.

### 📊 Performance Comparison (9000 Villagers) (Not From 1.20.1)
| Configuration               | TPS  | MSPT   |
|-----------------------------|------|--------|
| **Lithium + Async**         | 20   | 41.8   |
| **Lithium (without Async)** | 4.4  | 225.4  |
| **Purpur**                  | 5.72 | 176.18 |

### 🛠️ Test Configuration
- **Processor**: AMD Ryzen 9 7950X3D
- **RAM**: 64 GB (16 GB allocated to the server)
- **Minecraft Version**: 1.21.4
- **Number of Entities**: 9000
- **Entity Type**: Villagers

<details>
<summary>Mod List</summary>
Concurrent Chunk Management Engine, Fabric API, FerriteCore, Lithium, ScalableLux, ServerCore, StackDeobfuscator, TT20 (TPS Fixer), Tectonic, Very Many Players, Fabric Carpet.
</details>

## ⚠️ Incompatible Mods (1.20.1)
- ⚠️ If you find an incompatibility with this 1.20.1 port, report it in this repository's issue tracker.

*If you encounter an issue with this port, please report it in [this repository's issue tracker](https://github.com/JustHari01/HariMT-Public-Source/issues).*

## 🔧 Commands
- `/async config toggle` — Enables or disables the mod in-game (no server restart required). Use this command to instantly see how Async improves your server.
- `/async config setAsyncEntitySpawn` — Enables or disables parallel mob spawn processing (disabled by default). **Warning: Not compatible with Carpet mod lagFreeSpawning rule.**
- `/async config setAsyncRandomTicks` — Enables or disables async random ticks processing (experimental feature).
- `/async config synchronizedEntities add` — Adds selected entity to synchronized processing.
- `/async config synchronizedEntities remove` — Removes selected entity from synchronized processing.
- `/async stats` — Displays the number of threads in use.
- `/async stats entity` — Shows the number of entities processed by Async in various worlds.
- `/async stats entity [number]` — Shows the top [number] entity types by count in descending order. For example, `/async stats entity 10` displays the top 10 most numerous entity types.

## 📥 Download
The Forge 1.20.1 release is available on [Modrinth](https://modrinth.com/mod/he-harientity/) and [CurseForge](https://www.curseforge.com/minecraft/mc-mods/harientity). CurseForge also has the Fabric 1.20.1 file.

## Building

Use JDK 17 and run the Gradle wrapper from this directory:

```text
./gradlew :forge:jarJar
./gradlew :fabric:build
```

The first build downloads Minecraft, loader, and Maven dependencies. Both loader modules resolve Harium 2.0 from Modrinth Maven as a compile-only dependency; it is not bundled into this mod.

## 🔄 Minecraft Version Support
This port targets Minecraft 1.20.1. Compatibility depends on the other mods installed; report port-specific problems in this repository's issue tracker.

## 📭 Feedback
For issues in the original Async project, use its upstream tracker. For issues specific to this 1.20.1 port, use this repository's issue tracker:
[![Give feedback on GitHub](https://img.shields.io/badge/Report%20issues%20on-GitHub-lightgrey)](https://github.com/AxalotLDev/Async/issues)

You can also chat with me on their Discord:
[![Chat with us on Discord](https://img.shields.io/badge/Chat%20with%20us%20on-Discord-blue)](https://discord.com/invite/scvCQ2qKS3)

## 🙌 Acknowledgements
This mod is based on code from [MCMTFabric](https://modrinth.com/mod/mcmtfabric), which in turn was based on [JMT-MCMT](https://github.com/jediminer543/JMT-MCMT). Huge thanks to Grider and jediminer543 for their invaluable contributions!

## License
The source code in this repository is licensed under [GPL-3.0-only](LICENSE).

AI assistance was used in the compatibility port and in preparing this README. This note does not describe the upstream authors’ work.
