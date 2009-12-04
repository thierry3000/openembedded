DESCRIPTION = "Base meta install package for Enigma2 based Dreambox meta packages"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "proprietary"
MAINTAINER = "Mladen Horvat <acid-burn@opendreambox.org>"
DEPENDS = "enigma2 enigma2-plugins enigma2-skins"
RDEPENDS = "enigma2-meta enigma2-plugins-meta enigma2-skins-meta"

PN = "dreambox-meta"
PR = "r0"

ALLOW_EMPTY = 1
PACKAGES = "${PN}"

S = "${WORKDIR}"

PACKAGE_ARCH := "${MACHINE_ARCH}"
