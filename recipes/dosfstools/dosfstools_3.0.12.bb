# dosfstools OE build file
# Copyright (C) 2004-2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "DOS FAT Filesystem Utilities"

SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPLv3"

PR = "r3"

S="${WORKDIR}/dosfstools-3.0.14"
SRC_URI = "http://daniel-baumann.ch/files/software/dosfstools/dosfstools-${PV}.tar.gz \
	"
# output of getconf LFS_CFLAGS
#
CFLAGS_append = ' -D_LARGEFILE_SOURCE -D_FILE_OFFSET_BITS=64'
CFLAGS_append_libc-uclibc = ' ${@base_contains("DISTRO_FEATURES", "largefile", "-D_LARGEFILE_SOURCE -D_FILE_OFFSET_BITS=64", "", d)}'

do_install () {
	oe_runmake "PREFIX=${D}" "SBINDIR=${D}${sbindir}" \
		   "MANDIR=${D}${mandir}/man8" install
}
