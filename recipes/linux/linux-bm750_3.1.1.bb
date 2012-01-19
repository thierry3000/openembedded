require linux-vuplus-3.1.1.inc

PR = "r6"

SRC_URI += "\
        file://linux_3.1.1_bm750.patch;patch=1;pnum=1 \
        file://linux-sata_brcm.patch;patch=1;pnum=1 \
	"

