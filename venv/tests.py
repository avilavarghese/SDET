import pytest
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
import openpyxl

@pytest.fixture
def browser():
    driver = webdriver.Chrome()
    yield driver
    driver.quit()

def readExcelData(file_path, sheet_name):
    try:
        workbook = openpyxl.load_workbook(file_path)
        sheet = workbook[sheet_name]
        data = []
        for row in sheet.iter_rows(min_row=2, values_only=True):
            entry = {
            "username": row[0],
            "password": row[1],
        }
            data.append(entry)
        workbook.close()
        return data

    except Exception as e:
        print(f"Error reading Excel data: {e}")
        return None

def testSuccessfulLogins(browser):

    positiveData = readExcelData("C:/Users/frank.DESKTOP-2DFF4LO/venv/Data.xlsx", "Positive")
    if positiveData:
        for data_set in positiveData:

            browser.get("https://www.saucedemo.com/")
            assert "Avila" in browser.title

            usernameInput = browser.find_element(By.ID, "user-name")
            passwordInput = browser.find_element(By.ID, "password")
            submitButton = browser.find_element(By.ID, "login-button")

            usernameInput.send_keys({data_set['username']})
            passwordInput.send_keys({data_set['password']})
            submitButton.click()

            pageTitle = browser.find_element(By.CLASS_NAME, "app_logo").text
            assert "Swag Labs" in pageTitle

            print(f"Completed for: {data_set['username']}")

def testUnsuccessfulLogin(browser):

    browser.get("https://www.saucedemo.com/")
    assert "Swag Labs" in browser.title

    negativeData = readExcelData("C:/Users/frank.DESKTOP-2DFF4LO/venv/Data.xlsx", "Negative")
    if negativeData:
        for data_set in negativeData:

            usernameInput = browser.find_element(By.ID, "user-name")
            passwordInput = browser.find_element(By.ID, "password")
            submitButton = browser.find_element(By.ID, "login-button")

            usernameInput.send_keys({data_set['username']})
            passwordInput.send_keys({data_set['password']})
            submitButton.click()

            errorMessage = browser.find_element(By.CSS_SELECTOR, "h3[data-test='error']").text
            assert "Epic sadface: Sorry, this user has been locked out." in errorMessage

