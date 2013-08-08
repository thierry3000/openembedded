DESCRIPTION = "Vuplus: E2 Task for the Vuplus Distribution"
SECTION = "vuplus/base"
LICENSE = "MIT"
PR = "r29"

inherit task

PROVIDES = "\
  task-vuplus-ui \
  ${PACKAGES} \
"

PACKAGES = "\
  task-vuplus-enigma2 \
"

#
# task-vuplus-enigma2
#
RPROVIDES_task-vuplus-enigma2 = "task-vuplus-ui"
DESCRIPTION_task-vuplus-enigma2 = "Vuplus: Enigma2 Dependencies"
RDEPENDS_task-vuplus-enigma2 = "\
  enigma2 \
  enigma2-defaultservices \
  enigma2-plugin-extensions-mediascanner \
  enigma2-plugin-systemplugins-factorytest \
  enigma2-streamproxy \
  tuxbox-tuxtxt-32bpp \
  enigma2-meta \
  enigma2-plugins-meta \
  enigma2-skins-meta \   
  enigma2-plugin-systemplugins-crashreport \
  enigma2-plugin-systemplugins-3gmodemmanager \
  enigma2-plugin-extensions-streamtv \
  enigma2-plugin-extensions-dlnaserver \
  enigma2-plugin-extensions-dlnabrowser \
  enigma2-plugin-extensions-remotestreamconvert \
  enigma2-plugin-systemplugins-zappingmodeselection \
  enigma2-plugin-extensions-addstreamurl \
  enigma2-plugin-systemplugins-devicemanager \
  enigma2-plugin-systemplugins-videomode \
  enigma2-plugin-systemplugins-netdrive \
"


RRECOMMENDS_task-vuplus-enigma2 = "\
  aio-grab \
  python-crypt \
  python-netserver \
  python-twisted-core \
  python-twisted-protocols \
  python-twisted-web \
  enigma2-plugin-extensions-mediaplayer \
  enigma2-plugin-extensions-pictureplayer \
  enigma2-plugin-extensions-vuplusevent \
  enigma2-plugin-systemplugins-skinselector \
  enigma2-plugin-systemplugins-ui3dsetup \
  enigma2-plugin-systemplugins-uipositionsetup \
  enigma2-plugin-systemplugins-hdmicec \
  enigma2-plugin-systemplugins-wirelessaccesspoint \
  ${@base_contains("MACHINE_FEATURES", "wifi", "task-vuplus-wlan", "", d)} \
"

RDEPENDS_task-vuplus-enigma2_append_bm750 = "\
  enigma2-plugin-systemplugins-fancontrol \
  enigma2-plugin-extensions-hbbtv \
"
RDEPENDS_task-vuplus-enigma2_append_vuduo2 = "\
  enigma2-plugin-systemplugins-remotecontrolcode \
  enigma2-plugin-systemplugins-hdmicec \
  enigma2-plugin-extensions-openwebif \
  enigma2-plugin-extensions-hbbtv \
  duo2lcd4linux \
  lcd4linuxsupport \
  vuplus-blindscan-utils \
  vuplus-checkvfd \
  enigma2-plugin-systemplugins-firmwareupgrade \
  enigma2-plugin-systemplugins-manualfancontrol \
  enigma2-plugin-systemplugins-autoshutdown \
  enigma2-plugin-systemplugins-transcodingsetup \
  enigma2-plugin-systemplugins-blindscan \
  enigma2-transtreamproxy \
  enigma2-plugin-systemplugins-wolsetup \
"

RDEPENDS_task-vuplus-enigma2_append_vusolo2 = "\
  enigma2-plugin-extensions-openwebif \
  enigma2-plugin-systemplugins-remotecontrolcode \
  enigma2-plugin-systemplugins-hdmicec \
  enigma2-plugin-extensions-hbbtv \
  enigma2-plugin-systemplugins-firmwareupgrade \
  enigma2-plugin-systemplugins-manualfancontrol \
  enigma2-plugin-systemplugins-autoshutdown \
  enigma2-plugin-systemplugins-transcodingsetup \
  enigma2-transtreamproxy \
"

RDEPENDS_task-vuplus-enigma2_append_vuuno = "\
  vuplus-blindscan-utils \
  enigma2-plugin-systemplugins-fpgaupgrade \
  enigma2-plugin-systemplugins-blindscan \
  enigma2-plugin-systemplugins-manualfancontrol \
  enigma2-plugin-systemplugins-remotecontrolcode \
  enigma2-plugin-extensions-hbbtv \
"
RDEPENDS_task-vuplus-enigma2_append_vuultimo = "\
  vuplus-blindscan-utils \
  enigma2-plugin-systemplugins-firmwareupgrade \
  enigma2-plugin-systemplugins-blindscan \
  enigma2-plugin-systemplugins-manualfancontrol \
  enigma2-plugin-systemplugins-remotecontrolcode \
  enigma2-plugin-systemplugins-ledbrightnesssetup \
  enigma2-plugin-extensions-hbbtv \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"
