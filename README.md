# HariMT public source snapshots

This repository preserves clean source snapshots for the Minecraft 1.20.1 HariMT community port.

## Current source: HariMultiThread 2.0

The current source is in [`HariMultiThread-2.0/`](HariMultiThread-2.0/). It targets Minecraft 1.20.1 and includes Forge and Fabric build modules. Its declared license is GPL-3.0-only; see [`HariMultiThread-2.0/LICENSE`](HariMultiThread-2.0/LICENSE).

This snapshot matches the public [HariMultiThread repository](https://github.com/JustHari01/HariMultiThread) at commit [`52ce37d`](https://github.com/JustHari01/HariMultiThread/commit/52ce37d4ab0208f39761fd4e23c86170e81be39d). It contains source, assets, and build files, with the Gradle wrapper retained. It does not include compiled mod releases, generated build output, runtime worlds, downloaded dependencies, or development caches. Build instructions are in the snapshot's README.

## Earlier snapshot

The files at the repository root preserve the earlier HariMT 1.1.1 source snapshot (Gradle project version `0.1.7+alpha.6-1.20.1`). The older snapshot remains available for reference; use `HariMultiThread-2.0/` for the current 2.0 source.

## Project listings

- [HE: HariEntity on Modrinth](https://modrinth.com/mod/he-harientity)
- [HE: HariEntity on CurseForge](https://www.curseforge.com/minecraft/mc-mods/harientity)

AI assistance was used in preparing the HariMultiThread compatibility port and this source index. This disclosure describes the community port only, not the upstream authors' work.

## HariEntity 1.21.1 port

The unofficial Fabric and NeoForge 1.21.1 port source is in [`HariEntity-1.21.1/`](HariEntity-1.21.1/). It is based on Async's `multiloader-1.21.1` source and adapts HariMT's circuit breaker and entity safety defaults. This branch does not claim feature parity with HariMT 2.0; the 1.20.1 experimental GPU collision path and manual worker scheduling controls were not carried over. See the folder README for build requirements, attribution, license, and the full AI assistance disclosure.