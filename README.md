# HariMT

<div align="center">

![HariMT Logo](logo.png)

**Asynchronous Entity Ticking for Minecraft 1.20.1**

![License](https://img.shields.io/badge/License-GPL--3.0-blue.svg)
![Minecraft Version](https://img.shields.io/badge/Minecraft-1.20.1-green.svg)
![Forge](https://img.shields.io/badge/Support-Forge-orange.svg)
![Fabric](https://img.shields.io/badge/Support-Fabric-cream.svg)

</div>

---

HariMT is an experimental fork of the 1.20.1 port of [Async by AxalotLDev](https://github.com/AxalotLDev/Async), with Forge work based on [Bliss-tbh's Async-1.20.1](https://github.com/Bliss-tbh/Async-1.20.1). It includes Forge and Fabric modules for Minecraft 1.20.1.

This repository is a clean source snapshot. It includes source code and build files, but no compiled mod JARs, downloaded Minecraft/Forge artifacts, generated build output, or development caches. The original development repository and its commit history are not copied here.

## Features

- Asynchronous entity ticking across multiple CPU cores.
- Configurable parallelism through `harimt.toml`.
- Compatibility code for optimization mods including Lithium, Radium, and VMP.
- Experimental behavior: incorrect entity behavior or crashes are possible.

## Build

Use Java 17.

```sh
./gradlew :forge:build
./gradlew :fabric:build
```

On Windows, run the same tasks with `gradlew.bat`. Build outputs are written under each module's `build/libs` directory.

## Credits and license

HariMT is distributed under the GNU General Public License v3.0; see [LICENSE](LICENSE). The build metadata uses the SPDX identifier `GPL-3.0-only`.

- Original Async mod: [AxalotLDev](https://github.com/AxalotLDev/Async)
- Minecraft 1.20.1 Forge port: [Bliss-tbh](https://github.com/Bliss-tbh/Async-1.20.1)
- Earlier code contributions acknowledged upstream: [MCMTFabric](https://modrinth.com/mod/mcmtfabric) and [JMT-MCMT](https://github.com/jediminer543/JMT-MCMT)
- HariMT maintenance and changes: [JustHari01](https://github.com/JustHari01)

For issues with this fork, use [GitHub Issues](https://github.com/JustHari01/HariMT-Public-Source/issues). For upstream Async issues, use the original project's issue tracker.
