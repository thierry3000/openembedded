require linux-vuplus-3.1.1.inc

PR = "r7"

SRC_URI += "\
	file://linux-sata_brcm.patch;patch=1;pnum=1 \
	"

