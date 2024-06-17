package com.sealedclasses;

final class ServiceAccount implements Account
{

}

final class SavingAccount implements Account
{

}

public sealed interface Account permits ServiceAccount, SavingAccount
{
    default String getAccountName()
    {
        return "default account";
    }
}
