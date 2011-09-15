DESCRIPTION = "Library to access Blu-Ray disks"
SECTION = "libs/multimedia"
PRIORITY = "optional"
LICENSE = "LGPLv2.1"
PV = "0.0.0+${PR}+gitr${SRCREV}"

SRC_URI = "git://git.videolan.org/${PN}.git;branch=master;protocol=git"

SRCREV = "cc45b823d21f25a8ce682076c182ee51f2fe422f"
S = "${WORKDIR}/git"

inherit autotools lib_package pkgconfig

do_stage() {
        autotools_stage_all
}
