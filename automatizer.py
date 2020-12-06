import os
import glob


def change_path(old):
    path = '/home/kan/Descargas/'
    newpath = '/home/kan/IdeaProjects/SinoAlice/assets/data/'
    suffix = ' - SINoALICE Database.html'
    print(path + old + suffix)
    print(newpath + old + ".html")
    os.rename((path + old + suffix), (newpath + old + ".html"))


def move_img(typeold, typenew, card):
    path = '/home/kan/Descargas/' + typeold + ' - SINoALICE Database_files' + card
    newpath = '/home/kan/IdeaProjects/SinoAlice/assets/img_' + typenew + card
    os.rename(path, newpath)


def detect_card(path):
    txtfiles = []
    txtNames = []
    for file in glob.glob(path + '/CardS*.png'):
        txtfiles.append(file)
    for j in range(len(txtfiles)):
        number = txtfiles[j].find("CardS")
        txtNames.append("/" + txtfiles[j][number:])
    return txtNames


if __name__ == '__main__':
    weapons = "Weapons"
    nightmares = "Nightmares"
    armor = "Armor"

    change_path(weapons)
    change_path(nightmares)
    change_path(armor)

    cardsWeapons = detect_card("/home/kan/Descargas/Weapons - SINoALICE Database_files")
    cardsNightmares = detect_card("/home/kan/Descargas/Nightmares - SINoALICE Database_files")
    cardsArmors = detect_card("/home/kan/Descargas/Armor - SINoALICE Database_files")



    for n in range(len(cardsNightmares)):
        move_img(nightmares, "nightmares", cardsNightmares[n])

    for n in range(len(cardsWeapons)):
        move_img(weapons, "weapons", cardsWeapons[n])

    for n in range(len(cardsArmors)):
        move_img(armor, "armor", cardsArmors[n])
